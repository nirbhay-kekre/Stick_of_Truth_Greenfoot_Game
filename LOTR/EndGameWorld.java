import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameWorld extends World
{

    /**
     * Constructor for objects of class EndGameWorld.
     * 
     */
    public EndGameWorld()
    {    
        super(1280, 800, 1, true); 
          addObject(new EndMission(),getWidth()/2, getHeight()/2);
    }
}
