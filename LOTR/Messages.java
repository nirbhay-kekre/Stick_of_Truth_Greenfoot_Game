import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Messages extends Actor implements IMessageSubject
{
    private String txt = "";
    
    ArrayList<IMessageObserver> observers = new ArrayList<>();
    int count;
     GreenfootImage text;
    public void act() 
    {
       GreenfootImage backImage = new GreenfootImage("Messages.png");  
       
       
       
        if(count==0){
           text = new GreenfootImage("Something sinister lurks these forsests!", 24, new Color(53,14,0), null);
           this.count=1;
        }
       if("space".equals(Greenfoot.getKey()) ){
      
       if ( this.count == 1)
       {
        this.count=2; 
        text = new GreenfootImage("Aaaargh! Wood Elves!! ", 24, new Color(53,14,0), null); 
         notifyMessageObservers("ChangeStance");
        } else if ( this.count == 2)
         {
        this.count=3;
        text = new GreenfootImage("Die! You Pointy nosed creeps!", 24, new Color(53,14,0), null);   
        }
        else if ( this.count == 3)
         {
             notifyMessageObservers("StartGame");
        }
    }
    
      
        backImage.drawImage(text,20,60);
           setImage(backImage);
  
        
    }
    
    
     public void AttachObservers(IMessageObserver observer){
         observers.add(observer);
        }
     public void DetachObservers(IMessageObserver observer){
        observers.remove(observer);
        }
    public void notifyMessageObservers(String message){
              for (IMessageObserver observer:
             observers) {
            observer.UpdateFromMessages(message);
        }
    }

}
