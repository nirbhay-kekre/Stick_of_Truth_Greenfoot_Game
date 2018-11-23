import greenfoot.*;

public class HelpingCharactersFactory extends Actor{
	private static HelpingCharactersFactory instance;

 	public static synchronized HelpingCharactersFactory getHCFactory(){
 		if(instance==null){
 			instance = new HelpingCharactersFactory();
 		}
 		return instance;
 	}

 	private HelpingCharactersFactory(){

 	}

 	public void generateHelpingCharacter(String helpingcharacter){
 		HelpingCharacters hc = null;
 		if(helpingcharacter.equals("Health")){
 			hc = new Health();
 			getWorld().addObject(hc,1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
 		}
 		else if(helpingcharacter.equals("PowerSpell")) {
 			hc = new PowerSpell();
 			getWorld().addObject(hc,1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
 		}
 	}

}
