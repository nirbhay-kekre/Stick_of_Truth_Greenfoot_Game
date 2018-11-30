import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndLevelOneWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndLevelOneWorld extends World
{

    /**
     * Constructor for objects of class EndLevelOneWorld.
     * 
     */
    public EndLevelOneWorld()
    {    
        super(1280, 800, 1, true); 
          addObject(new LevelComplete(),getWidth()/2, getHeight()/2);
    }
}
