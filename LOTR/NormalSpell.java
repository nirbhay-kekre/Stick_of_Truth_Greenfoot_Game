import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalSpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalSpell extends Actor
{
       public void act() 
    {
       splatter();
       getEnemy();
       move(20);
        
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }    
    } 
        public void getEnemy() 
    {
        if (isTouching(Elf.class))
        {
            removeTouching(Elf.class);
            getWorld().addObject(new Elf(), Greenfoot.getRandomNumber(getWorld().getWidth()/2), Greenfoot.getRandomNumber(getWorld().getHeight()));

        }
    }
    public void splatter()
    {
         if(isTouching(Elf.class))
        {
            LeafSplat splat = new LeafSplat();
            getWorld().addObject(splat, getX(), getY());
        }
    }
    
    
    
}
