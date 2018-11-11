public interface IMessageSubject  
{
    void AttachObservers(IMessageObserver observer);
    void DetachObservers(IMessageObserver observer);
    void notifyMessageObservers(String message);
}
