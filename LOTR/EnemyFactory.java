import greenfoot.*;
import java.util.*;

public class EnemyFactory extends Actor{

    private static EnemyFactory factory;
    private static Map<Integer, Set<Enemy>> readyToUseEnemies = new HashMap<Integer, Set<Enemy>>();
    private static Map<Integer, Set<Enemy>> enemiesUnderUse = new HashMap<Integer, Set<Enemy>>();
    
    public static synchronized EnemyFactory getEnemyFactory(){
        if(factory == null){
            factory = new EnemyFactory();
        }
        return factory;
    }
    
    private EnemyFactory(){
        readyToUseEnemies.put(0, new HashSet<Enemy>());
        readyToUseEnemies.put(1, new HashSet<Enemy>());
        
        enemiesUnderUse.put(0, new HashSet<Enemy>());
        enemiesUnderUse.put(1, new HashSet<Enemy>());
    }
    
    public void generateRandomEnemy(boolean recreateEnemy){
        int randomNumber = Greenfoot.getRandomNumber(2);
        generateEnemy(randomNumber, recreateEnemy);
    }
    
    public void generateEnemy(int enemyCode, boolean recreateEnemy){
        IMoveStrategy newMoveStrategy;
        Set<Enemy> usableEnemies = readyToUseEnemies.get(enemyCode); 
        Enemy enemy = null;
        if(usableEnemies!=null){
            
            if(usableEnemies.isEmpty()){
                switch(enemyCode){
                    case 0: 
                
                        if ( Greenfoot.getRandomNumber(100) < 30 )
                        {
                            // 30% time sinusoidal strategy
                             newMoveStrategy = new SinusoidalMovementStrategy();
                        } else {
                            // 70% time straight strategy
                            newMoveStrategy = new StraightMovementStrategy();
                        }
                        enemy =  new Elf(newMoveStrategy, recreateEnemy);
                        break;
                    case 1:
                        enemy = new Snake(recreateEnemy);
                        break;
                }
                //System.out.println(enemy.hashCode()+" : Enemy "+ enemy.getClass()+" Created");
                
            }else{
                enemy = usableEnemies.iterator().next();
                enemy.setRecreateEnemies(recreateEnemy);
                enemy.resetHealth();
                //System.out.println(enemy.hashCode()+" : Enemy "+ enemy.getClass()+" Reused");
            }
            
            usableEnemies.remove(enemy);
            enemiesUnderUse.get(enemyCode).add(enemy);
            getWorld().addObject(enemy, 1280, Greenfoot.getRandomNumber(getWorld().getHeight()));
        }
    }

    public void distroyEnemy(Enemy enemy){
        int enemyCode = 0;
        if (enemy instanceof Elf){
            enemyCode = 0;
        } else if(enemy instanceof Snake){
            enemyCode = 1;
        }
        else {
            return;
        }
        enemiesUnderUse.get(enemyCode).remove(enemy);
        readyToUseEnemies.get(enemyCode).add(enemy);
        //System.out.println(enemy.hashCode()+" : Enemy "+ enemy.getClass()+" added back to reusable pool.");
    }
}