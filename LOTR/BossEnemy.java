import greenfoot.*; 
import java.util.List;
import java.util.ArrayList;

public class BossEnemy extends Enemy implements IScoreBoardHealthSubject
{
    private int direction =1, magnitude =2;
    private boolean isgenerated=false;
    
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
        move(this.direction * this.magnitude);
        shootSpell();
    }
    
    public void moveAround(){
        if( getX()>=getWorld().getWidth()+1000){
            generateEnemy();
            this.direction=-1;
        }
        if(getX()<=getWorld().getWidth()-150){
            isgenerated=false;
            this.direction=1;
        }
        if(getX()<=getWorld().getWidth()){
            this.magnitude = 2;
        } else {
            this.magnitude = 4;
        }
    }
    
    public void generateEnemy(){
        if(!isgenerated){
            int numOfEnemiesGenerate = 3+ Greenfoot.getRandomNumber(3);
            while(numOfEnemiesGenerate -- >0){
                EnemyFactory.getEnemyFactory().generateRandomEnemy(false);
            }
            isgenerated=true;
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
    
    public void shootSpell(){
        if(this.getX() == this.getWorld().getWidth() && this.direction > 0){
            BossEnemySpell bs1 = new BossEnemySpell(false);
            BossEnemySpell bs2 = new BossEnemySpell(false);
            BossEnemySpell bs3 = new BossEnemySpell(false);
            
            int rotation = Greenfoot.getRandomNumber(45);
            bs1.setRotation(30 + rotation);
            bs2.setRotation(285 + rotation);
            this.getWorld().addObject(bs1,getX(),getY());
            this.getWorld().addObject(bs2,getX(),getY());
            this.getWorld().addObject(bs3,getX(),getY());
        }
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

