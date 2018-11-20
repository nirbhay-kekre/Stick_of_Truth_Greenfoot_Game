import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends HelpingCharacters
{
    private IMoveStrategy movementStrategy;
    private int healthPower;
    
    public Health() {
        healthPower = 10;
        this.movementStrategy = new StraightMovementStrategy();
        this.movementStrategy.setActor(this);
    }
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.movementStrategy.moveActor();
        this.removeHealthOnEdge();
    }
    
    public void removeHealthOnEdge(){
        if(this.isAtEdge() && getX() ==0){
            getWorld().removeObject(this);
        }
    }
    
    public int getHealthPower(){
        return healthPower;
    }
}
