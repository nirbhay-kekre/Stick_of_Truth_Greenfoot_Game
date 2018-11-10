import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 800, 1); 
        GreenfootSound backgroundMusic = new GreenfootSound("bgm.mp3");
        backgroundMusic.playLoop();
        Logo logo =new Logo();
        grandWizard gw = new grandWizard();
        ProfChaos pc = new ProfChaos();
        HighElf he = new HighElf();
        MarshWalker mw = new MarshWalker();
        Board board = new Board();
        addObject(gw,100,680);
        addObject(pc,400,680);
        addObject(he,700,680);
        addObject(mw,1000,680);
        addObject(logo,getWidth()/2, 300);
        addObject(board,1200,680);
    }
}
