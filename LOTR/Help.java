import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends Actor
{
    public void act() 
    {
        removeOnClick();
    }
    public void removeOnClick(){
         if (Greenfoot.mouseClicked(this)) {
                Greenfoot.playSound("clickoff.wav");
                World world;
                world = getWorld();
                world.removeObject(this);
                return;
            }    
    }     
}
