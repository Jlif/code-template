package tech.jiangchen.concurrent;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 等待通知模型实现单生产者单消费者
 */
public class ProducerConsumerDemo1 {

    private static final Object lock = new Object();
    private static final List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }


    static class Producer implements Runnable {

        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (list.isEmpty()) {
                        int i = new Random().nextInt(100);
                        System.out.println("生产 - " + i);
                        list.add(i);
                    } else {
                        lock.wait();
                    }
                    Thread.sleep(200);
                    lock.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (!list.isEmpty()) {
                        System.out.println("消费 - " + list.remove(0));
                    } else {
                        lock.wait();
                    }
                    Thread.sleep(150);
                    lock.notifyAll();
                }
            }
        }
    }
}
