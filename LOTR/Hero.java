import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Characters implements IScoreBoardHealthSubject
{
    private List<IScoreBoardHealthObserver> observers = new ArrayList<IScoreBoardHealthObserver>();
    
    public Hero(){
        this.registerScoreBoardHealthObserver(HealthScoreBoard.getHealthScoreBoard());
    }
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        isHitByEnemy();
        isGotHealth();
    }    
    
    protected boolean isHitByEnemy(){
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
    
    protected boolean isGotHealth(){
        /*if(isTouching(Health.class)){
            
        }*/
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
    
}
