package tech.jiangchen.chainOfResponsibility.v3;

public class HandlerB implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        System.out.println("print B");
        return handled;
    }
}
