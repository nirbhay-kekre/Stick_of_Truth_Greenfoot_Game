import greenfoot.*; 
import java.util.List;
import java.util.ArrayList;

public class BossEnemy extends Enemy implements IScoreBoardHealthSubject
{
    int moveValue=4;
    boolean isgenerated=false;
       // in a subclass of Actor
    private long curTime, prevTime;
    private static final long DELAY_TIME = 5000; // in milliseconds
    private int damagingPower = 5;
    private int health =100;
    
    private List<IScoreBoardHealthObserver> observers = new ArrayList<IScoreBoardHealthObserver>();
    
    public BossEnemy(boolean recreateEnemies){
        super(recreateEnemies);
        this.registerScoreBoardHealthObserver(BossEnemyHealthScoreBoard.getHealthScoreBoard());
        this.notifyScoreBoardForHealthUpdate(this.health);
    }
    
    
    public void act() 
    {
        super.act();
        if(health <=0){
          this.setLocation(1000,380);
          int numOfExplosions =10;
          int delayInExplosion = 3000000;
          int currentFrame =0;
          while(numOfExplosions >0){
              if(currentFrame ==0){
                  numOfExplosions--;
                  showExplosion();
              }
              currentFrame = (currentFrame +1) % delayInExplosion;
          }
          getWorld().removeObject(this);
          return;
        }
      
        moveAround();
        move(moveValue);
    }
    
    public void moveAround(){
        
        if( getX()>=getWorld().getWidth()+1000){
            if(!isgenerated){
            int numOfEnemiesGenerate = 3+ Greenfoot.getRandomNumber(3);
            while(numOfEnemiesGenerate -- >0){
                 EnemyFactory.getEnemyFactory().generateRandomEnemy(false);
            }
             isgenerated=true;
            }
            this.moveValue=-4;
        
        }
        if(getX()<=getWorld().getWidth()-150){
            this.moveValue=0;
            isgenerated=false;
            //System.out.println(getX());
            /*if(1128==getX()){  
               curTime = System.currentTimeMillis();
               if (prevTime +DELAY_TIME > curTime) {
                   return;
               } else {
                    prevTime = curTime;
               } 
             }*/
            this.moveValue=+2;
        
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
        notifyScoreBoardForHealthUpdate(health);
    }
    
    
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        observers.add(observer);
    }
    
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        observers.remove(observer);
    }
    
    public void notifyScoreBoardForHealthUpdate(int updatedHealth){
        for(IScoreBoardHealthObserver observer : observers){
             observer.updateScoreBoardHealth(updatedHealth);
        }
    }
    
    public void reduceHealth(int reduceBy){
        int health = getHealth();
        health = (health - reduceBy) > 0 ? health - reduceBy :0;
        setHealth(health);
        notifyScoreBoardForHealthUpdate(health);
    }
    
    public void showExplosion(){
        Explosion explosion = new Explosion();
        int randomx = Greenfoot.getRandomNumber(2);
        int randomy = Greenfoot.getRandomNumber(2);
        int xdist = Greenfoot.getRandomNumber(15);
        int ydist = Greenfoot.getRandomNumber(50);
        if(randomx == 0 ){
            xdist *=-1;
        }
        if(randomy == 0){
            ydist *=-1;
        }
        getWorld().addObject(explosion,this.getX() + xdist, this.getY() +ydist);
    }
}

