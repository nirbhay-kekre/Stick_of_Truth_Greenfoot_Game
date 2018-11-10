import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LeafSplat extends Actor
{
    /**
     * Act - do whatever the LeafSplat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        despawn();
    }    
    private int life = 50;
     public void despawn()
    {
        life--;
        if (life == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
