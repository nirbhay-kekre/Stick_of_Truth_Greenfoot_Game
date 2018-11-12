import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LeafSplat extends Actor
{
    GifImage gifImage;
    
    public LeafSplat(){
    gifImage=  new GifImage("leaves.gif");
    
    }
    public void act() 
    {
        setImage(gifImage.getCurrentImage());
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
