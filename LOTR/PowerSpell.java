import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerSpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerSpell extends HelpingCharacters
{
    private IMoveStrategy movementStrategy;
    private int numberOfSpells;
    
    public PowerSpell() {
        numberOfSpells = 3;
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
        this.removePowerSpellOnEdge();
    }
    
    public void removePowerSpellOnEdge(){
        if(this.isAtEdge() && getX() ==0){
            getWorld().removeObject(this);
        }
    }
    
    public int getNumberOfSpells(){
        return numberOfSpells;
    }  
}
