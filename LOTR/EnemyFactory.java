import greenfoot.*;

public class EnemyFactory extends Actor{

    private static EnemyFactory factory;
    
    public static synchronized EnemyFactory getEnemyFactory(){
        if(factory == null){
            factory = new EnemyFactory();
        }
        return factory;
    }
    
    private EnemyFactory(){
        
    }
    
    public void generateRandomEnemy(){
        int randomNumber = Greenfoot.getRandomNumber(2);
        generateEnemy(randomNumber);
    }
    
    public void generateEnemy(int enemyCode){
        IMoveStrategy newMoveStrategy;
    	switch(enemyCode){
    		case 0: 
    			
                        if ( Greenfoot.getRandomNumber(100) < 30 )
                        {
                            // 30% time sinusoidal strategy
                            newMoveStrategy = new SinusoidalMovementStrategy();
                        }else {
                            // 70% time straight strategy
                            newMoveStrategy = new StraightMovementStrategy();
                        }
                        getWorld().addObject(new Elf(newMoveStrategy), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
    			break;

    		case 1:
    			getWorld().addObject(new Snake(), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
    			break;

    		default:
    			
                        if ( Greenfoot.getRandomNumber(100) < 30 )
                        {
                            // 30% time sinusoidal strategy
                            newMoveStrategy = new SinusoidalMovementStrategy();
                        }else {
                            // 70% time straight strategy
                            newMoveStrategy = new StraightMovementStrategy();
                        }
                        getWorld().addObject(new Elf(newMoveStrategy), 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
    			break;

    	}
    }
}