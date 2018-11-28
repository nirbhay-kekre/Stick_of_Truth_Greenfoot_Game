import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Legend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Legend extends MenuItems
{
  public void act() 
    {
            if(Greenfoot.mouseClicked(this)){
            invoke();           
        }   
    }
    
    
    ICommand legendCommand;
    public void setCommand(ICommand cmd){
     this.legendCommand = cmd;
    }
    public void invoke(){
    legendCommand.execute(); 
    }  
}
