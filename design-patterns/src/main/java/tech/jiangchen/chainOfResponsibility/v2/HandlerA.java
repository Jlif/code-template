package tech.jiangchen.chainOfResponsibility.v2;

public class HandlerA extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("打印 A");
        return handled;
    }
}
