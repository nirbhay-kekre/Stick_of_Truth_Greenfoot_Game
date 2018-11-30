import greenfoot.*;
/**
 * implementation for straight movement strategy of an actor.
 * 
 * @author nirbhaykekre
 */
public class ReflectiveMovementStrategy implements IMoveStrategy 
{
    private int movingSpeed;
    private Actor actor;
    
    /**
     * Constructor for objects of class StraightMovementStrategy
     */
    public ReflectiveMovementStrategy(){
        this.movingSpeed = -6;
    }
    
    /**
     * sets Actor on which movement strategy needs to be applied.
     * 
     * @param actor - actor on which movement strategy will be applied.
     */
    public void setActor(Actor actor){
        this.actor = actor;
    }
    
    /**
     * Moves the actor forward with moving speed
     */
    public void moveActor(){
        this.actor.move(this.movingSpeed);
        rotateActor();
    }
    
    /**
     * Actor is not rotated in straight movement strategy
     */
    public void rotateActor(){
        
            if(actor.getY() <= 26 ){
                actor.turn( - 2 * actor.getRotation());
            }else if(actor.getY() >= 774){
                actor.turn( 2 * (360- actor.getRotation()));
            }
        
    }
    
    /**
     * chages the moving speed of actor
     */
    public void changeSpeed(int speed){
        this.movingSpeed = speed;
    }
    
    private int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
