import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalSpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalSpell extends Actor
{
     private int life = (Greenfoot.getRandomNumber(50) + 100);
    public void act() 
    {
       move(20);
        life--;
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }    
    }    
}
