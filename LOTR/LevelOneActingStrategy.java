import greenfoot.*;
public class LevelOneActingStrategy  implements ActingStrategy

{
    World world;
    Hero  hero;
    public void doAction(){
    }
  
    
    public void setWorld(World world){
        this.world=world;
    }
     public void setHero(Hero hero){
        this.hero=hero;
    }
}
