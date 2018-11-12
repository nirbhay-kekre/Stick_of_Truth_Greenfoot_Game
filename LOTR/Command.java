public class Command implements ICommand {
    IReceiver receiver;
    @Override
    public void execute() {
        receiver.doAction();
    }

    @Override
    public void setReciever(IReceiver receiver) {
        this.receiver=receiver;
    }
}
