import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Enemy
{
    private IMoveStrategy moveStrategy;
    private int damagingPower = 5;
    private int health =1;
    
    public Elf(IMoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.moveStrategy.setActor(this);
    }
    
    public void changeMovementStrategy(IMoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.moveStrategy.setActor(this);
    }
    
    public void actorOnEdgeAction(){
        if (this.isAtEdge() && getX() ==0){
            // move creation of elf to factory
            IMoveStrategy newMoveStrategy;
            if ( Greenfoot.getRandomNumber(100) < 30 )
            {
                // 30% time sinusoidal strategy
                newMoveStrategy = new SinusoidalMovementStrategy();
            }else {
                // 70% time straight strategy
                newMoveStrategy = new StraightMovementStrategy();
            }
            getWorld().addObject(new Elf(newMoveStrategy), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
            getWorld().removeObject(this);
        }
    }
    
    public void act() 
    {
         super.act();
         
         if(health <=0){
             IMoveStrategy newMoveStrategy;
            if ( Greenfoot.getRandomNumber(100) < 30 )
            {
                // 30% time sinusoidal strategy
                newMoveStrategy = new SinusoidalMovementStrategy();
            }else {
                // 70% time straight strategy
                newMoveStrategy = new StraightMovementStrategy();
            }
            getWorld().addObject(new Elf(newMoveStrategy),1280, Greenfoot.getRandomNumber(getWorld().getHeight()));  
            LeafSplat splat = new LeafSplat();
            getWorld().addObject(splat, getX(), getY());
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
