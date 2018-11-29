import greenfoot.*;  

public class BossBattleWorld extends World 
{

    private Characters ch;
    public BossBattleWorld()
    {    
        super(1280, 800, 1, false); 
        
        ch= new TheGrandWizard(false);
        addObject(ch,getWidth()/2,getHeight()/2);
        
        ch= new BossEnemy(false);
        addObject(ch,1000,380);  
        
        EnemyFactory enemy = EnemyFactory.getEnemyFactory();
        addObject(enemy,0,0);
         
    }
    
   


}
