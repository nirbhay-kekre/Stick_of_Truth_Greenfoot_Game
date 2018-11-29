import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MarshWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarshWalker extends Hero
{ActingStrategy currentStrategy;
      public MarshWalker(boolean recreateEnemies){
          
   super(recreateEnemies);
        currentStrategy= new LevelZeroActingStrategy();
    }
    

    public void act() 
    {
        super.act();  
       
         
        if(getWorld().getClass().getName().equals("MainMenu")){
        currentStrategy= new LevelZeroActingStrategy();
        currentStrategy.setWorld(getWorld());
        currentStrategy.setHero(this);
        currentStrategy.doAction();
        }else if(getWorld().getClass().getName().equals("ForestWorld")){
        currentStrategy= new LevelOneActingStrategy();
        currentStrategy.setWorld(getWorld());
        currentStrategy.setHero(this);
        currentStrategy.doAction();
        }else if(getWorld().getClass().getName().equals("BossBattleWorld")){
        currentStrategy= new LevelTwoActingStrategy();
        currentStrategy.setWorld(getWorld());
        currentStrategy.setHero(this);
        currentStrategy.doAction();
        }
         
    } 
    
    public void setStance(String stance){
          switch(stance){
        case "Attack": setImage(new GreenfootImage("marshwalker_stance.png"));
                        break;
        case "Stand": setImage(new GreenfootImage("marshwalker.png"));
                        break;                
        }
    }
}
