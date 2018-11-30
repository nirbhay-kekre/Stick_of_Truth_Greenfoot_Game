import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossEnemyHealthScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossEnemyHealthScoreBoard extends Actor implements IScoreBoardHealthObserver
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int health;
    private static BossEnemyHealthScoreBoard instance;
    private int lagInGenerationOfHealth = 30;
    private int currentFrame = 1;

    
    /**
     * Get singleton instace of health scoreboard
     */
    public static synchronized BossEnemyHealthScoreBoard getHealthScoreBoard(){
        if(instance ==null){
            instance = new BossEnemyHealthScoreBoard();
        }
        return instance;
    }
    
    /**
     * Create a new HealthScoreboard, health is initialized to max. 
     */
    private BossEnemyHealthScoreBoard()
    {
        background = getImage();  // get image from class
        health = 100;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        
    }
    
    /**
     * updates the health score board
     */
    public void updateScoreBoardHealth(int updatedHealth)
    {
        
        health = updatedHealth;
        updateImage();
           if(health== 0){
        Greenfoot.setWorld(new EndGameWorld());
            }
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
        health = 100;
        updateImage();
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Boss: " + health, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }  
}
