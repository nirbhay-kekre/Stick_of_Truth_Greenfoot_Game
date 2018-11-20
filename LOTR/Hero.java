import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Characters implements IScoreBoardHealthSubject, IScoreBoardPowerSpellSubject
{
    private List<IScoreBoardHealthObserver> observers = new ArrayList<IScoreBoardHealthObserver>();
    private List<IScoreBoardPowerSpellObserver> powerSpellObservers = new ArrayList<IScoreBoardPowerSpellObserver>();
    public Hero(){
        this.registerScoreBoardHealthObserver(HealthScoreBoard.getHealthScoreBoard());
        this.registerScoreBoardPowerSpellObserver(PowerSpellBoard.getPowerSpellBoard());
    }
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateOnHitByEnemy();
        updateOnGotHealth();
        updateOnTouchingPowerSpell();
    }    
    
    protected boolean updateOnHitByEnemy(){
        if(isTouching(Enemy.class)){
            Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
            int damage = enemy.getDamagingPower();
            notifyScoreBoardForHealthUpdate(damage > 0 ? -damage : damage);
            //System.out.println("Hit by Enemy: "+ enemy.getClass()+ " Damage caused:" +damage);
            this.removeTouching(Enemy.class);
            IMoveStrategy newMoveStrategy;
            if ( Greenfoot.getRandomNumber(100) < 30 )
            {
                    // 30% time sinusoidal strategy
                    newMoveStrategy = new SinusoidalMovementStrategy();
            }else {
                    // 70% time straight strategy
                    newMoveStrategy = new StraightMovementStrategy();
            }
            getWorld().addObject(new Elf(newMoveStrategy),1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
            return true;
        }
        return false;
    }
    
    protected boolean updateOnGotHealth(){
        if(isTouching(Health.class)){
            Health health = (Health) getOneIntersectingObject(Health.class);
            int healthPower = health.getHealthPower();
            
            notifyScoreBoardForHealthUpdate(healthPower > 0 ? healthPower: 0);
            this.removeTouching(Health.class);
        }
        return false;
    }
    
    protected boolean updateOnTouchingPowerSpell(){
        if(isTouching(PowerSpell.class)){
            PowerSpell powerSpell = (PowerSpell) getOneIntersectingObject(PowerSpell.class);
            int numberOfPowerSpell = powerSpell.getNumberOfSpells();
            
            notifyScoreBoardForPowerSpellUpdate(numberOfPowerSpell > 0 ? numberOfPowerSpell: 0);
            this.removeTouching(PowerSpell.class);
        }
        return false;
    }
    
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        observers.add(observer);
    }
    
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        observers.remove(observer);
    }
    
    public void notifyScoreBoardForHealthUpdate(int deltaHealth){
        for(IScoreBoardHealthObserver observer : observers){
             observer.updateScoreBoardHealth(deltaHealth);
        }
    }
    
    public void registerScoreBoardPowerSpellObserver(IScoreBoardPowerSpellObserver observer){
        powerSpellObservers.add(observer);
    }
    public void unregisterScoreBoardPowerSpellObserver(IScoreBoardPowerSpellObserver observer){
        powerSpellObservers.remove(observer);
    }
    public void notifyScoreBoardForPowerSpellUpdate(int powerSpell){
        for(IScoreBoardPowerSpellObserver observer : powerSpellObservers){
             observer.updateScoreBoardPowerSpell(powerSpell);
        }
    }
}
