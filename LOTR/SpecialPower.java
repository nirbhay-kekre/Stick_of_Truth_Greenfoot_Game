import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpecialPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialPower extends Powers
{
    int kills=0;
       public void act() 
    {
       splatter();
       getEnemy();
       move(20);
        try{
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        } }catch(Exception e){
        }   
    } 
        public void getEnemy() 
    {
        if (isTouching(Elf.class))
        {
            removeTouching(Elf.class);
            getWorld().addObject(new Elf(0-getRandomNumber(2,5)),1280, Greenfoot.getRandomNumber(getWorld().getHeight())); 
            kills+=1;
            if(kills==5){
                 getWorld().removeObject(this);
            }
            
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
    
        public int getRandomNumber(int start,int end)
{
           int normal = Greenfoot.getRandomNumber(end-start+1);
           return normal+start;
}
    
    
}
