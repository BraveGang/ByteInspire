package org.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 实现生产者消费者模型
 * 阻塞队列BlockingQueue的实现
 */
public class ProducerConsumer03 {


    public static Integer count = 0;
    public final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    public static void main(String[] args) {

        ProducerConsumer03 producerConsumer03 = new ProducerConsumer03();
        new Thread(producerConsumer03.new Producer()).start();
        //new Thread(producerConsumer03.new Consumer()).start();
        new Thread(producerConsumer03.new Producer()).start();
        //new Thread(producerConsumer03.new Consumer()).start();
        new Thread(producerConsumer03.new Producer()).start();
        //new Thread(producerConsumer03.new Consumer()).start();
        new Thread(producerConsumer03.new Producer()).start();
        new Thread(producerConsumer03.new Consumer()).start();
        new Thread(producerConsumer03.new Producer()).start();
        new Thread(producerConsumer03.new Consumer()).start();

    }

}
