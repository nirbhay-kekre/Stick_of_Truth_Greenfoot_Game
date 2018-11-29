import greenfoot.*;
public class LevelTwoActingStrategy implements ActingStrategy
{
    
    int val;
     Hero hero;
    World world;
    
    public void doAction(){
        int speed = 5;
        if(Greenfoot.isKeyDown("up"))
            hero.setLocation(hero.getX(), hero.getY() - speed);
        if(Greenfoot.isKeyDown("down"))
            hero.setLocation(hero.getX(), hero.getY() + speed);
        if(Greenfoot.isKeyDown("left"))
           hero. setLocation(hero.getX() - speed, hero.getY());
        if(Greenfoot.isKeyDown("right")){
            this.val =hero.getX() + speed;
            if(hero.getX() + speed> (hero.getWorld().getWidth()/2)+100){
            hero.setLocation((hero.getWorld().getWidth()/2)+100, hero.getY());
            }else{
           hero. setLocation(hero.getX() + speed, hero.getY());
            } 
        }
           if ("space".equals(Greenfoot.getKey()))
        { 
                fire();
        }
    }
        private void fire()
    {
        NormalSpell ns = new NormalSpell();
        hero.getWorld().addObject(ns, hero.getX(), hero.getY());
        ns.move(40);
    }
    
   public void setHero(Hero hero){
        this.hero=hero;
    }
    
     public void setWorld(World world){
        this.world=world;
    }
}

