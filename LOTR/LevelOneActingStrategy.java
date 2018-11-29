import greenfoot.*;
public class LevelOneActingStrategy  implements ActingStrategy

{
    World world;
    Hero  hero;
    public void doAction(){
         int speed = 5;
        if(Greenfoot.isKeyDown("up"))
            hero.setLocation(hero.getX(), hero.getY() - speed);
        if(Greenfoot.isKeyDown("down"))
            hero.setLocation(hero.getX(), hero.getY() + speed);
    }
  
    
    public void setWorld(World world){
        this.world=world;
    }
     public void setHero(Hero hero){
        this.hero=hero;
    }
}
