import greenfoot.*;
/**
 * Interface for movement strategy of an actor.
 * 
 * @author nirbhaykekre 
 */
public interface IMoveStrategy  
{
    /**
     * sets the actor on which strategy needs to be applied.
     */
    public void setActor(Actor actor);
    
    /**
     * moves the actor forward.
     */
    public void moveActor();
    
    /**
     * rotates the actor
     */
    public void rotateActor();
    
    /**
     * chages the moving speed of actor
     */
    public void changeSpeed(int speed);
}
