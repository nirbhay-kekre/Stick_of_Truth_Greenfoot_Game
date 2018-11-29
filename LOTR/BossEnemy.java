import greenfoot.*; 

public class BossEnemy extends Enemy 
{
     int moveValue=4;
     boolean isgenerated=false;
       // in a subclass of Actor
    private long curTime, prevTime;
    private static final long DELAY_TIME = 5000; // in milliseconds
      private int damagingPower = 5;
    private int health =50;
    public BossEnemy()
    {  
       
    }
    
    
    public void act() 
    {
      super.act();
      
       moveAround();
       move(moveValue);
    }
    
    public void moveAround(){
        
        if( getX()>=getWorld().getWidth()+1000){
            if(!isgenerated){
               getWorld().addObject(new Elf2(), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
                getWorld().addObject(new Elf2(), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
                getWorld().addObject(new Elf2(), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
             isgenerated=true;
            }
        this.moveValue=-4;
        
        }
        if(getX()<=getWorld().getWidth()-150){
            this.moveValue=0;
            isgenerated=false;
            System.out.println(getX());
             if(1128==getX()){  
               curTime = System.currentTimeMillis();
                 if (prevTime +DELAY_TIME > curTime) {
                      return;
                    } else {
                    prevTime = curTime;
                } 
             }
            this.moveValue=+4;
        
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

