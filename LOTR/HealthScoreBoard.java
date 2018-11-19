import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthScoreBoard extends Actor implements IScoreBoardHealthObserver
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int health;
    private int maxHealth =100;
    private static HealthScoreBoard instance;
    
    /**
     * Get singleton instace of health scoreboard
     */
    public static synchronized HealthScoreBoard getHealthScoreBoard(){
        if(instance ==null){
            instance = new HealthScoreBoard();
        }
        return instance;
    }
    
    /**
     * Create a new HealthScoreboard, health is initialized to max. 
     */
    private HealthScoreBoard()
    {
        background = getImage();  // get image from class
        health = maxHealth;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        //do nothing
    }

    /**
     * updates the health score board
     */
    public void updateScoreBoardHealth(int deltaHealth)
    {
        
        health = health+deltaHealth > maxHealth ? 
                       maxHealth : health+deltaHealth < 0 ?
                                    0: health+deltaHealth;
        updateImage();
    }

    /**
     * Return the current health value.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     *  This method will reset the health scoreboard, Since health scoreboard is a singleton class, we have introduced this method
     *  to reset the score board if user hits reset on greenfoot.
     */
    protected void resetHealth(){
        health = maxHealth;
        updateImage();
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Health: " + health, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }  
}
