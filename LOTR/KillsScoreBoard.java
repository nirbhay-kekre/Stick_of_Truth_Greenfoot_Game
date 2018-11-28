import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KillsScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KillsScoreBoard extends Actor implements IScoreBoardKillCountObserver
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int kill;
    private int maxKill =100;
    private static KillsScoreBoard instance;
    
    /**
     * Get singleton instace of health scoreboard
     */
    public static synchronized KillsScoreBoard getKillsScoreBoard(){
        if(instance ==null){
            instance = new KillsScoreBoard();
        }
        return instance;
    }
    
    /**
     * Create a new HealthScoreboard, kill is initialized to 0. 
     */
    public KillsScoreBoard(){
        background = getImage();  // get image from class
        kill = 0;
        updateImage();
    }
    /**
     * Act - do whatever the KillsScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
    }    
    
    public void updateScoreBoardKillCount(int killCount){
        kill += killCount;
        kill = (kill > maxKill) ? maxKill: kill;
        updateImage();
    
        
    }
    
    /**
     * Return the current kill count value.
     */
    public int getKillCount()
    {
        return kill;
    }
    
    /**
     *  This method will reset the kill count scoreboard, Since scoreboard is a singleton class, we have introduced this method
     *  to reset the score board if user hits reset on greenfoot.
     */
    protected void resetKills(){
        kill = 0;
        updateImage();
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Kills: " + kill +"/"+maxKill, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    } 
}
