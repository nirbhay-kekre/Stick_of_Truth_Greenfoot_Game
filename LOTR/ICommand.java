public interface ICommand {
    void execute();
    void setReciever(IReceiver receiver);
}
