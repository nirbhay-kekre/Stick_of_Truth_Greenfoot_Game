import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalSpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalSpell extends Powers
{
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
            IMoveStrategy newMoveStrategy;
            if ( Greenfoot.getRandomNumber(100) < 30 )
            {
                // 30% time sinusoidal strategy
                newMoveStrategy = new SinusoidalMovementStrategy();
            }else {
                // 70% time straight strategy
                newMoveStrategy = new StraightMovementStrategy();
            }
            getWorld().addObject(new Elf(newMoveStrategy),1280, Greenfoot.getRandomNumber(getWorld().getHeight()));  
            getWorld().removeObject(this); 
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
