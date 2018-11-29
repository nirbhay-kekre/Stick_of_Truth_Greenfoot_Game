import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighElf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheGrandWizard extends Hero
{
    
        public Cries generateRandomCry(){
         Cries cries;   
        int randomNumber = Greenfoot.getRandomNumber(2);
        switch(randomNumber){
        case 1: cries= new ShallCarry();
                 return cries;
        case 0: cries= new ToWar();
                 return cries;
        default: cries= new ToWar();
                 return cries;         
        }
    }
    public void act() 
    {
      
        super.act();
        
        int speed = 3;
        if(Greenfoot.isKeyDown("up"))
            setLocation(getX(), getY() - speed);
        if(Greenfoot.isKeyDown("down"))
            setLocation(getX(), getY() + speed);
        if(Greenfoot.isKeyDown("left"))
            setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("right"))
            setLocation(getX() + speed, getY());
           if ("space".equals(Greenfoot.getKey()))
        { 
           
                fire();
            
        }
            
            
    } 
    
        private void fire()
    {
        NormalSpell ns = new NormalSpell();
        getWorld().addObject(ns, getX(), getY());
        
        ns.move(40);
    }
    
    public void setStance(String stance){
     switch(stance){
        case "Attack": setImage(new GreenfootImage("cartman_stance.png"));
                        break;
        case "Stand": setImage(new GreenfootImage("grand-wizard.png"));
                        break;                
        }
    }
}
