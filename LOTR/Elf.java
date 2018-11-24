import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Enemy
{
    private IMoveStrategy moveStrategy;
    private int damagingPower = 5;
    private int health =1;
    private EnemyFactory enemy ;
    /**
    * Constructor for Elf
    */
    public Elf(IMoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.moveStrategy.setActor(this);
        enemy = EnemyFactory.getEnemyFactory();
    }
    
    /**
    * Strategy pattern, changing movement strategy from straight to sinusoidal or vice versa
    */
    public void changeMovementStrategy(IMoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.moveStrategy.setActor(this);
    }
    
    /**
    * When Elf touches the edge of the screen
    */
    public void actorOnEdgeAction(){
        if (this.isAtEdge() && getX() ==0){
            
            enemy.generateRandomEnemy();
            getWorld().removeObject(this);
        }
    }
    
    public void act() 
    {
         super.act();
         
         if(health <=0){
            EnemyFactory enemy = EnemyFactory.getEnemyFactory();
            enemy.generateRandomEnemy();  
            showExplosion();
            getWorld().removeObject(this);
         }else{
         this.moveStrategy.moveActor();
         actorOnEdgeAction();
        }
    }
    
    public int getDamagingPower(){
        return damagingPower;
    }
    
    public int getHealth(){
        return health;
    }
    
    protected void setHealth(int health){
        this.health = health;
    }
}
