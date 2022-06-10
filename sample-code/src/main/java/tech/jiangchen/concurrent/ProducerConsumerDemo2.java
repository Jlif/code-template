package tech.jiangchen.concurrent;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 等待通知模型实现多生产者多消费者
 */
public class ProducerConsumerDemo2 {

    private static final Object lock = new Object();
    private static final List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Producer(), "生产者2").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Consumer(), "消费者2").start();
    }


    static class Producer implements Runnable {

        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (!list.isEmpty()) {
                        lock.wait();
                    }
                    int i = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    list.add(i);
                    Thread.sleep(100);
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
                    while (list.isEmpty()) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " - " + list.remove(0));
                    Thread.sleep(100);
                    lock.notifyAll();
                }
            }
        }
    }

}
