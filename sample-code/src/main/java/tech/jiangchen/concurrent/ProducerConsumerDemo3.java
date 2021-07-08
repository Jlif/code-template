package tech.jiangchen.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jiangchen
 * @date 2021/07/07
 */

/**
 * 使用阻塞队列模拟实现生产消费模型
 */
public class ProducerConsumerDemo3 {

    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20, true);

    public static void main(String[] args) {
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Producer(), "生产者2").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Consumer(), "消费者2").start();
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    int i = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + "生产 - " + i);
                    queue.put(i);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "消费 - " + queue.take());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
