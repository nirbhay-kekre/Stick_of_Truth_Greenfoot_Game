import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighElf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheGrandWizard extends Hero
{
    /**
     * Act - do whatever the HighElf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
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
