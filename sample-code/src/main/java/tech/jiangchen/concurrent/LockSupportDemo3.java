package tech.jiangchen.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * interrupt起到的作用与unpark一样
 *
 * @author jiangchen
 * @date 2021/07/13
 */
public class LockSupportDemo3 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread(Thread.currentThread());
        myThread.start();
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
            System.out.println("before interrupt");
            try {
                // 休眠3s
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = (Thread) object;
            // 中断线程
            thread.interrupt();
            System.out.println("after interrupt");
        }
    }

}
