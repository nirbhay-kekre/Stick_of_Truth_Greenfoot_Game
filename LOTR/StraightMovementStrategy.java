import greenfoot.*;
/**
 * implementation for straight movement strategy of an actor.
 * 
 * @author nirbhaykekre
 */
public class StraightMovementStrategy implements IMoveStrategy 
{
    private int movingSpeed;
    private Actor actor;
    
    /**
     * Constructor for objects of class StraightMovementStrategy
     */
    public StraightMovementStrategy(){
        this.movingSpeed = 0-getRandomNumber(2,6);
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
    }
    
    /**
     * Actor is not rotated in straight movement strategy
     */
    public void rotateActor(){
        //no rotation needed in straight movement
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
