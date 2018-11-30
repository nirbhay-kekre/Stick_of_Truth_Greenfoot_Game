import greenfoot.*;  

public class BossBattleWorld extends World 
{

    private BossEnemy bossEnemy;
    private Hero hero;
    private HealthScoreBoard healthScore;
    private BossEnemyHealthScoreBoard BossHealthScore;
    private HelpingCharactersFactory helpingcharacters;
    private KillsScoreBoard killScore;
    
    public BossBattleWorld()
    {    
        super(1280, 800, 1, false); 
        
        hero= HeroSingleton.getInstance().getCharacter();
        if(hero == null){
            hero = new TheGrandWizard(false);
        }
        hero.setRecreateEnemies(false);
        addObject(hero,getWidth()/2,getHeight()/2);
        
        bossEnemy= new BossEnemy(false);
        addObject(bossEnemy,1000,380);  
        
        EnemyFactory enemy = EnemyFactory.getEnemyFactory();
        addObject(enemy,0,0);
        
        healthScore = HealthScoreBoard.getHealthScoreBoard();
        addObject(healthScore, 108, 26);
        
        BossHealthScore = BossEnemyHealthScoreBoard.getHealthScoreBoard();
        addObject(BossHealthScore, 1108, 26);
        
        helpingcharacters = HelpingCharactersFactory.getHCFactory();
        addObject(helpingcharacters,0,0);
        
        killScore = KillsScoreBoard.getKillsScoreBoard();
        killScore.resetKills();
        
    }
}
