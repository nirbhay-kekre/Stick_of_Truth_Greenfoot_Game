import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartMission extends MenuItems implements IInvoker
{

    
    public void act() 
    {
            if(Greenfoot.mouseClicked(this)){
            invoke();           
        }
       
        
    }
    
    
    ICommand startMissionCommand;
    public void setCommand(ICommand cmd){
     this.startMissionCommand = cmd;
    }
    public void invoke(){
    startMissionCommand.execute(); 
    }
    
    
}