import greenfoot.*; 
import java.util.*;
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
       //GreenfootSound backgroundMusic = new GreenfootSound("bgm.mp3");
       //backgroundMusic.playLoop();
        
        MenuItems logo =new Logo();
        addObject(logo,getWidth()/2, 200);
        
        MenuItems legend =new Legend();
        addObject(legend,getWidth()/2-30, 500);
        MenuItems startMission =new StartMission();
        addObject(startMission,getWidth()/2, 400);
        //Character Initializations
        Characters gw = new TheGrandWizard(false);
        addObject(gw,100,680);
        
        Characters pc = new ProfChaos(false);
        addObject(pc,400,680);
        
        Characters he = new HighElf(false);
        addObject(he,700,680);
        
        Characters mw = new MarshWalker(false);
        addObject(mw,1000,680);
        
        Board board = new Board();
        addObject(board,1200,680);
        
        ICommand legendCommand =new Command();
        ICommand levelOneCommand = new Command();
        
        legendCommand.setReciever(new IReceiver() {
            @Override
            public void doAction() {
                Greenfoot.playSound("clickon.wav");
               Story story =new Story();
               addObject(story,getWidth()/2,getHeight()/2);
            }
        });
        
        levelOneCommand.setReciever(new IReceiver() {
            @Override
            public void doAction() {
                Greenfoot.playSound("clickon.wav");
                Hero temp =HeroSingleton.getInstance().getCharacter();
             try{  if(!temp.equals(null)){
                  Greenfoot.setWorld(new ForestWorld());
              }
            }catch(Exception e){
                ChooseHero ch =new ChooseHero();
               addObject(ch,getWidth()/2,getHeight()/2);
            }
              
            }
        });
        legend.setCommand(legendCommand);
        startMission.setCommand(levelOneCommand);
       }
}
