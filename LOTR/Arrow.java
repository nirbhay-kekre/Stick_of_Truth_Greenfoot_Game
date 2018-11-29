import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor implements IScoreBoardPowerSpellSubject
{
    private List<IScoreBoardPowerSpellObserver> powerSpellObservers = new ArrayList<IScoreBoardPowerSpellObserver>();
    public Arrow(){
        this.registerScoreBoardPowerSpellObserver(PowerSpellBoard.getPowerSpellBoard());
    }
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation (getRotation() - 5);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            setRotation (getRotation() + 5);
        }
        
         int speed = 5;
        if(Greenfoot.isKeyDown("up"))
            setLocation(getX(), getY() - speed);
        if(Greenfoot.isKeyDown("down"))
            setLocation(getX(), getY() + speed);
        
        if ("space".equals(Greenfoot.getKey()))
        { 
             if (Greenfoot.isKeyDown("shift") && hasSpecialPower())
            { 
                fireSpecial();
            }else{
                fire();
            } 
        }
    }  
    
    public boolean hasSpecialPower(){
        return PowerSpellBoard.getPowerSpellBoard().getCurrentPowerSpells() > 0;
    }
      private void fire()
    {
        NormalSpell ns = new NormalSpell();
        getWorld().addObject(ns, getX(), getY());
        ns.setRotation(getRotation()-50);
        ns.move(40);
    }
    
       private void fireSpecial()
    {
        SpecialPower ns = new SpecialPower();
        getWorld().addObject(ns, getX(), getY());
        ns.setRotation(getRotation()-50);
        ns.move(40);
        notifyScoreBoardForPowerSpellUpdate(-1);
    }
    
    public void registerScoreBoardPowerSpellObserver(IScoreBoardPowerSpellObserver observer){
        powerSpellObservers.add(observer);
    }
    public void unregisterScoreBoardPowerSpellObserver(IScoreBoardPowerSpellObserver observer){
        powerSpellObservers.remove(observer);
    }
    public void notifyScoreBoardForPowerSpellUpdate(int powerSpell){
        for(IScoreBoardPowerSpellObserver observer : powerSpellObservers){
             observer.updateScoreBoardPowerSpell(powerSpell);
        }
    }
}
