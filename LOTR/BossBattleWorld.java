import greenfoot.*;  

public class BossBattleWorld extends World 
{

    private Characters ch;
    public BossBattleWorld()
    {    
        super(1280, 800, 1, false); 
        
        ch= new TheGrandWizard();
        addObject(ch,getWidth()/2,getHeight()/2);  
       
        
        ch= new BossEnemy();
        addObject(ch,1000,380);  
        
        EnemyFactory enemy = EnemyFactory.getEnemyFactory();
         addObject(enemy,0,0);
         
    }
    
   


}
