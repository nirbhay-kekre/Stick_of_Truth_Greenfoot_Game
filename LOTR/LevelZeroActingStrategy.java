import greenfoot.*;
public class LevelZeroActingStrategy  implements ActingStrategy

{
    Hero hero;
    World world;
    
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
    
    public void doAction(){
        if (Greenfoot.mouseClicked(hero)) {
                   Greenfoot.playSound("clickon.wav");
                   Cries temp =HeroSingleton.getInstance().getCry();
            try{  if(!temp.equals(null)){
                  hero.getWorld().removeObject(temp);
              }
            }catch(Exception e){
           }
                 HeroSingleton.getInstance().setCharacter(hero);
                 Cries cries = generateRandomCry();
                 HeroSingleton.getInstance().setCry(cries);
                 hero.getWorld().addObject(cries,hero.getX(),580);
           }
                
             
    }
  
    
    public void setHero(Hero hero){
        this.hero=hero;
    }
    
     public void setWorld(World world){
        this.world=world;
    }
}
