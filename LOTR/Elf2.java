import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf2 extends Enemy
{
    private IMoveStrategy moveStrategy;
    private int damagingPower = 5;
    private int health =1;

    /**
    * Constructor for Elf2
    */
    public Elf2(){
        
        this.moveStrategy = new StraightMovementStrategy();
        this.moveStrategy.setActor(this);
       
    }
    
    /**
    * Strategy pattern, changing movement strategy from straight to sinusoidal or vice versa
    */
    public void changeMovementStrategy(IMoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.moveStrategy.setActor(this);
    }
    
    /**
    * When Elf2 touches the edge of the screen
    */
    public void actorOnEdgeAction(){
      
    }
    
    public void act() 
    {
         super.act();
         
         if(health <=0){
            showExplosion();
            getWorld().removeObject(this);
         }else{
         this.moveStrategy.moveActor();
         actorOnEdgeAction();
        }
    }
    
    public int getDamagingPower(){
        return damagingPower;
    }
    
    public int getHealth(){
        return health;
    }
    
    protected void setHealth(int health){
        this.health = health;
    }
    
 
}
