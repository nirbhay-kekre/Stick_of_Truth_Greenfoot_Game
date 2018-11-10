import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Characters
{
    /**
     * Act - do whatever the Elf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
         Move();
    }
    
    public void Move()
    {
        move(-2);
        if (isAtEdge()){
          //Reduce Score
          getWorld().removeObject(this);
        }

    }
    
}
