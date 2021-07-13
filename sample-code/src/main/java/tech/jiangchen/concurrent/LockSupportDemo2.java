package tech.jiangchen.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author jiangchen
 * @date 2021/07/13
 */
public class LockSupportDemo2 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }

    static class MyThread extends Thread {

        private Object object;

        public MyThread(Object object) {
            this.object = object;
        }

        public void run() {
            System.out.println("before unpark");
            // 释放许可
            LockSupport.unpark((Thread) object);
            System.out.println("after unpark");
        }
    }

}
