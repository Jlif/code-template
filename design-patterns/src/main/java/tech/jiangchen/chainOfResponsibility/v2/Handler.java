package tech.jiangchen.chainOfResponsibility.v2;

public abstract class Handler {

    protected Handler successor = null;

    protected abstract boolean doHandle();

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }
}
