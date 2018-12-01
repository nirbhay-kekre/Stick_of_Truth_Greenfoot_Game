import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossEnemySpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossEnemySpell extends Enemy
{
    private IMoveStrategy moveStrategy;
    private int damagingPower = 20;
    private int maxHealth = Integer.MAX_VALUE;
    private int health ;
    
    public BossEnemySpell(boolean recreateEnemies){
        super(recreateEnemies);
        moveStrategy = new ReflectiveMovementStrategy();
        moveStrategy.setActor(this);
        health = maxHealth;
    }
    /**
     * Act - do whatever the BossEnemySpell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveStrategy.moveActor();
        if (this.isAtEdge() && getX() ==0){
            getWorld().removeObject(this);
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
