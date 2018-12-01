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
    private int damagingPower = 10;
    private int maxHealth =1;
    private int health;
    private EnemyFactory enemyFactory ;
    
    /**
    * Constructor for Elf
    */
    public Elf(IMoveStrategy moveStrategy, boolean recreateEnemies){
        super(recreateEnemies);
        this.moveStrategy = moveStrategy;
        this.moveStrategy.setActor(this);
        health = maxHealth;
        enemyFactory = EnemyFactory.getEnemyFactory();
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
    
    protected void resetHealth(){
        this.health = maxHealth;
    }
}
