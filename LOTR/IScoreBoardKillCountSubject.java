/**
 * Subeject interface for kill count scoreboard
 * 
 * @author nirbhaykekre
 */
public interface IScoreBoardKillCountSubject  
{
    public void registerScoreBoardKillObserver(IScoreBoardKillCountObserver observer);
    public void unregisterScoreBoardKillObserver(IScoreBoardKillCountObserver observer);
    public void notifyScoreBoardForKillCountUpdate(int kills);
}
