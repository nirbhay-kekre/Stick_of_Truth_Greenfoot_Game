import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalSpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalSpell extends Powers
{
    private int damagingPower = 1;
    
    public void act() 
    {
        super.act();
        move(20);
        
        if (isAtEdge() || damagingPower <=0)
        {
            getWorld().removeObject(this);
        }
       
    } 
    
    
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    public int getDamagingPower(){
        return damagingPower;
    }
    
    protected void setDamagingPower(int damagingPower){
        this.damagingPower = damagingPower;
    }
}
