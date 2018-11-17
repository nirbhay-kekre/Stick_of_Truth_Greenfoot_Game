import greenfoot.*;
/**
 * implementation for straight movement strategy of an actor.
 * 
 * @author nirbhaykekre
 */
public class SinusoidalMovementStrategy implements IMoveStrategy 
{
    private int movingSpeed;
    private Actor actor;
    private int turnAfterStep =50;
    private int currentStep =1;
    private int toggler =1;
    
    /**
     * Constructor for objects of class StraightMovementStrategy
     */
    public SinusoidalMovementStrategy(){
        this.movingSpeed = 0-getRandomNumber(2,6);
    }
    
    /**
     * sets Actor on which movement strategy needs to be applied.
     * 
     * @param actor - actor on which movement strategy will be applied.
     */
    public void setActor(Actor actor){
        this.actor = actor;
        this.actor.setRotation(-45);
    }
    
    /**
     * Moves the actorforward with moving speed then rotates it follow sinusoidal path.
     */
    public void moveActor(){
        this.actor.move(this.movingSpeed);
        rotateActor();
    }
    
    /**
     * toggles the rotation of the actor between 90 and -90 degree
     */
    public void rotateActor(){
        if(currentStep % turnAfterStep ==0){
            this.actor.turn(90*toggler);
            toggler *= -1;
        }
        currentStep++;
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
