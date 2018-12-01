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
    private int damagingPower = 20;
    private int maxHealth =1;
    private int health;
    private EnemyFactory enemyFactory ;
    /**
    * Constructor for Snake
    */
    public Snake(boolean recreateEnemies){
        super(recreateEnemies);
        this.moveStrategy = new SinusoidalMovementStrategy();
        this.moveStrategy.setActor(this);
        health = maxHealth;
        enemyFactory = EnemyFactory.getEnemyFactory();
    }
    
    /**
    * When Elf touches the edge of the screen
    */
    public void actorOnEdgeAction(){
        if (this.isAtEdge() && getX() ==0){
            getWorld().removeObject(this);
            enemyFactory.distroyEnemy(this);
            if(this.getRecreateEnemies()){
                enemyFactory.generateRandomEnemy(this.getRecreateEnemies());
            }
        }
    }
    
    public void act() 
    {
         super.act();
         
         if(health <=0){
            showExplosion();
            getWorld().removeObject(this);
            enemyFactory.distroyEnemy(this);
            if(this.getRecreateEnemies()){
                enemyFactory.generateRandomEnemy(this.getRecreateEnemies());
            }
        } else {
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
    
    protected void resetHealth(){
        this.health = maxHealth;
    }
}
