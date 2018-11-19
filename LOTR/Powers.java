import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Powers extends Actor
{
   
    protected abstract void setDamagingPower(int damagingPower);
    
    public abstract int getDamagingPower();
    
    public void reduceDamagingPower(int reducedBy){
        int updatedPower =this.getDamagingPower() - reducedBy;
        this.setDamagingPower(updatedPower > 0 ? updatedPower : 0);
    }
    
}
