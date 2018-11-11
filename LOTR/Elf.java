import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Characters
{
    int speed;
    public Elf(int speed){
        this.speed =speed;
    }
    
    public void act() 
    {
         Move();
    }
    
    public void Move()
    {
        move(speed);
        if (isAtEdge()){
          //Reduce Score
          
          getWorld().addObject(new Elf(0-getRandomNumber(2,5)), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
          getWorld().removeObject(this);
         
        }

    }
    
    public int getRandomNumber(int start,int end)
{
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
}
    
}
