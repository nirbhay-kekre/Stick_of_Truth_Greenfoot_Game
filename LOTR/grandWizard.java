import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class grandWizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class grandWizard extends Characters
{
    /**
     * Act - do whatever the grandWizard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void setStance(String stance){
     switch(stance){
        case "Attack": setImage(new GreenfootImage("cartman_stance.png")); break;
     case "Stand": setImage(new GreenfootImage("grand-wizard.png")); break;
         
    }
    }
}
