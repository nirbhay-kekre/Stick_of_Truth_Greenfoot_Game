import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay extends MenuItems
{
    public void act() 
    {
            if(Greenfoot.mouseClicked(this)){
            invoke();           
        }   
    }
    
    
    ICommand howToPlayCommand;
    public void setCommand(ICommand cmd){
     this.howToPlayCommand = cmd;
    }
    public void invoke(){
    howToPlayCommand.execute(); 
    }   
}
