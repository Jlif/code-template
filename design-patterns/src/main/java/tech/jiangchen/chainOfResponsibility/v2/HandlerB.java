package tech.jiangchen.chainOfResponsibility.v2;

public class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("print B");
        return handled;
    }
}
