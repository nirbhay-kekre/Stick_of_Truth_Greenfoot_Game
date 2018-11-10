import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestWorld extends World
{

    /**
     * Constructor for objects of class ForestWorld.
     * 
     */
    public ForestWorld()
    {    
        super(1280, 800, 1); 
               
        //Character Initializations
        Characters gw = new grandWizard();
        gw.setStance("Attack");
        addObject(gw,100,680);
        
        Arrow arrow =new Arrow();
        addObject(arrow,180,630);
        
        
        
        
        
        
        
        
       
        
    }
}
