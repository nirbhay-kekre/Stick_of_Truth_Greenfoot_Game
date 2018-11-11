import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        super(1280, 800, 1); 
        //Music
        GreenfootSound backgroundMusic = new GreenfootSound("bgm.mp3");
        backgroundMusic.playLoop();
        
        MenuItems logo =new Logo();
        addObject(logo,getWidth()/2, 200);
        
        MenuItems legend =new Legend();
        addObject(legend,getWidth()/2-30, 500);
        MenuItems startMission =new StartMission();
        addObject(startMission,getWidth()/2, 400);
        //Character Initializations
        Characters gw = new TheGrandWizard();
        addObject(gw,100,680);
        
        
        Characters pc = new ProfChaos();
        addObject(pc,400,680);
        
        Characters he = new HighElf();
        addObject(he,700,680);
        
        Characters mw = new MarshWalker();
        addObject(mw,1000,680);
        
        
        Board board = new Board();
        addObject(board,1200,680);
        
        
        
        
        
        
        
       
        
    }
}
