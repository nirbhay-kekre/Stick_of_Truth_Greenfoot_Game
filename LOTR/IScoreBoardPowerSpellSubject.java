/**
 * Write a description of class IScoreBoardPowerSpellSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IScoreBoardPowerSpellSubject  
{
    public void registerScoreBoardPowerSpellObserver(IScoreBoardPowerSpellObserver observer);
    public void unregisterScoreBoardPowerSpellObserver(IScoreBoardPowerSpellObserver observer);
    public void notifyScoreBoardForPowerSpellUpdate(int powerSpell);
}
