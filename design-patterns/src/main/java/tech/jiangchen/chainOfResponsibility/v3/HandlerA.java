package tech.jiangchen.chainOfResponsibility.v3;

public class HandlerA implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        System.out.println("print A");
        return handled;
    }
}
