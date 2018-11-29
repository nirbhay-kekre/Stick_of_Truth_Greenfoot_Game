import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProfChaos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProfChaos extends Hero
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
         if (Greenfoot.mouseClicked(this)) {
             World world;
                world = getWorld();
             
                
                if(world.getClass().getName().equals("MainMenu")){
                    Greenfoot.playSound("clickon.wav");
                     Cries temp =HeroSingleton.getInstance().getCry();
            try{  if(!temp.equals(null)){
                  world.removeObject(temp);
              }
            }catch(Exception e){
            }
                 HeroSingleton.getInstance().setCharacter(this);
                 Cries cries = generateRandomCry();
                 HeroSingleton.getInstance().setCry(cries);
               getWorld().addObject(cries,400,580);
                }
                
            } 
        
    }  
    
    public void setStance(String stance){
          switch(stance){
        case "Attack": setImage(new GreenfootImage("Professor-chaos.png"));
                        break;
        case "Stand": setImage(new GreenfootImage("butters.png"));
                        break;                
        }
    }
}
