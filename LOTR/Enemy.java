import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Characters implements IScoreBoardKillCountSubject
{
    private List<IScoreBoardKillCountObserver> observers = new ArrayList<IScoreBoardKillCountObserver>();

    public Enemy(){
        this.registerScoreBoardKillObserver(KillsScoreBoard.getKillsScoreBoard());
    }
    
    abstract public int getDamagingPower();
    
    public void reduceHealth(int reduceBy){
        int health = getHealth();
        health = (health - reduceBy) > 0 ? health - reduceBy :0;
        setHealth(health);
    }
    
    abstract protected void setHealth(int health);
    
    abstract public int getHealth();  

    public void registerScoreBoardKillObserver(IScoreBoardKillCountObserver observer){
        observers.add(observer);
    }
    public void unregisterScoreBoardKillObserver(IScoreBoardKillCountObserver observer){
        observers.remove(observer);
    }
    public void notifyScoreBoardForKillCountUpdate(int kills){
        for(IScoreBoardKillCountObserver observer : observers){
             observer.updateScoreBoardKillCount(kills);
        }
    }
    
    public void act(){
        Powers spell = (Powers)getOneIntersectingObject(Powers.class);
        if(spell !=null ){
            int damage = spell.getDamagingPower();
            damage = damage > 0 ? damage : 0;
            int health = getHealth();
            
            reduceHealth(damage);
            spell.reduceDamagingPower(health);
        }
        if(getHealth() == 0){
            notifyScoreBoardForKillCountUpdate(1);
        }
        
    }
    
    public void showExplosion(){
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion, this.getX(), this.getY());
    }
}
