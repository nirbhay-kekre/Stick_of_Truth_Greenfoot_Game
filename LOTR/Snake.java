import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Enemy
{
   private IMoveStrategy moveStrategy;
    private int damagingPower = 2;
    private int health =1;
    private EnemyFactory enemy ;
    /**
    * Constructor for Snake
    */
    public Snake(boolean recreateEnemies){
        super(recreateEnemies);
        this.moveStrategy = new SinusoidalMovementStrategy();
        this.moveStrategy.setActor(this);
        enemy = EnemyFactory.getEnemyFactory();
    }
    
    /**
    * When Elf touches the edge of the screen
    */
    public void actorOnEdgeAction(){
        if (this.isAtEdge() && getX() ==0){
            if(this.getRecreateEnemies()){
                enemy.generateRandomEnemy(this.getRecreateEnemies());
            }
            getWorld().removeObject(this);
        }
    }
    
    public void act() 
    {
         super.act();
         
         if(health <=0){
            if(this.getRecreateEnemies()){
                enemy.generateRandomEnemy(this.getRecreateEnemies());
            }  
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
