import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor
{
    GifImage gifImage;
    
    public Explosion(){
        IImageIterator iterator = ImageRepository.getImageRepository().getImgageIterator();
        if(iterator.hasNext()){
            iterator.moveToNext();
            gifImage = iterator.currentImage();
        }else{
            //if there are no images in repository continue with default image of leaves.gif
            new GifImage("leaves.gif");
        }
        
    
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
