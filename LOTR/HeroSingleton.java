
public class HeroSingleton  
{
    
    private static HeroSingleton HeroSingleton_instance = null;
    private Hero hero;
    private Cries cries;
    public static HeroSingleton getInstance() {
        if (HeroSingleton_instance == null)
            HeroSingleton_instance = new HeroSingleton();
        return HeroSingleton_instance;
    }

    public void setCharacter(Hero hero) {
        this.hero = hero;
    }
    
       public Hero getCharacter() {
        return this.hero;
    }
    
    
    
   public void setCry(Cries cries) {
        this.cries = cries;
    }
    
         public Cries getCry() {
        return this.cries;
    }
}
