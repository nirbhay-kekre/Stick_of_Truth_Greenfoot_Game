/**
 * Subeject interface for health scoreboard
 * 
 * @author nirbhaykekre
 */
public interface IScoreBoardHealthSubject  
{
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer);
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer);
    public void notifyScoreBoardForHealthUpdate(int deltaHealth);
}
