import greenfoot.*;  
/**
 * Write a description of class ForestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestWorld extends World implements IMessageObserver
{

    Characters ch;
    private Messages messages;
    private int difficulty;
    private HealthScoreBoard healthScore;
    private KillsScoreBoard killScore;
     
    public ForestWorld()
    {    
        super(1280, 800, 1); 
        setDifficulty();   
        //Character Initializations
         messages = new Messages();
         messages.AttachObservers(this);
         addObject(messages,600,680);
         
         healthScore = HealthScoreBoard.getHealthScoreBoard();
         healthScore.resetHealth();
         addObject(healthScore, 108, 26);
         
         killScore = KillsScoreBoard.getKillsScoreBoard();
         killScore.resetKills();
         addObject(killScore, 308, 26);

         ch= new TheGrandWizard();
         addObject(ch,100,680);

    }
    
    public void startGame(){
         Arrow arrow =new Arrow();
         addObject(arrow,180,630);
         for(int i=0;i<difficulty;i++){
             IMoveStrategy newMoveStrategy;
             if ( Greenfoot.getRandomNumber(100) < 30 )
             {
                 // 30% time sinusoidal strategy
                 newMoveStrategy = new SinusoidalMovementStrategy();
             }else {
                 // 70% time straight strategy
                 newMoveStrategy = new StraightMovementStrategy();
             }
             addObject(new Elf(newMoveStrategy), 1280, Greenfoot.getRandomNumber( getHeight()));        
        }
        removeObject(messages);
     
    }

     public void changeCharacterStance(){
     ch.setStance("Attack"); 
    }

    public void setDifficulty(){
        //this.difficulty= difficulty;
        this.difficulty= 5;
    }

    public void UpdateFromMessages(String message){
        if(message.equals("ChangeStance")){
            ch.setStance("Attack");
        }else if(message.equals("StartGame")){
            startGame();
        }
    }
}
