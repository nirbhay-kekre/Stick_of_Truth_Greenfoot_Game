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
    private int health = Integer.MAX_VALUE;
    
    public BossEnemySpell(boolean recreateEnemies){
        super(recreateEnemies);
        moveStrategy = 
    }
    /**
     * Act - do whatever the BossEnemySpell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
}
