import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndMission here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndMission extends Actor
{
 public void act() 
    {
        removeOnClick();
    }
        public void removeOnClick()
        {
         if (Greenfoot.mouseClicked(this)) {
             Greenfoot.playSound("clickoff.wav");
                Greenfoot.setWorld(new MainMenu());
                return;
            }    
    }     
}
