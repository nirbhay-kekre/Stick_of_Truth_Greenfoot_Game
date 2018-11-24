import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerSpellBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerSpellBoard extends Actor implements IScoreBoardPowerSpellObserver
{
    private int maxPowerSpells = 3;
    private int currentPowerSpells = 0;
    private int intervalForGeneration =300;
    private int probabilityToGeneratePowerSpell = 70;
    private int currentFrame =1;
    private static PowerSpellBoard instance;
    private GreenfootImage background;
    private static final Color transparent = new Color(0,0,0,0);
    private HelpingCharactersFactory hcfactory;

    public static synchronized PowerSpellBoard getPowerSpellBoard(){
        if(instance ==null){ 
            instance = new PowerSpellBoard();
        }
        return instance;
    }

    private PowerSpellBoard(){
        background = getImage();  // get image from class
        currentPowerSpells = 0;
        updateImage();
        hcfactory = HelpingCharactersFactory.getHCFactory();
    }
    /**
     * Act - do whatever the PowerSpellBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        currentFrame++;
        currentFrame = currentFrame % intervalForGeneration;
        if(currentFrame == 0 && getWorld().getObjects(PowerSpell.class).size() < 1){
            if(Greenfoot.getRandomNumber(100) < probabilityToGeneratePowerSpell){
                generatePowerSpell();
            }
        }
    }
    
    private void generatePowerSpell(){
        //generate using factory
        hcfactory.generateHelpingCharacter("PowerSpell");
    }

    public void updateScoreBoardPowerSpell(int powerSpells){
        currentPowerSpells = currentPowerSpells + powerSpells;
        currentPowerSpells = currentPowerSpells > maxPowerSpells ? maxPowerSpells : currentPowerSpells < 0 ? 0: currentPowerSpells;
        updateImage();
    }
    
    /**
     *  This method will reset the power spell scoreboard, Since power spell scoreboard is a singleton class, we have introduced this method
     *  to reset the score board if user hits reset on greenfoot.
     */
    protected void resetPowerSpells(){
        currentPowerSpells = 0;
        updateImage();
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(": " + currentPowerSpells, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    public int getCurrentPowerSpells(){
        return currentPowerSpells;
    }
}
