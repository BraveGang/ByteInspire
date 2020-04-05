package org.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现生产者消费者模型
 * 可重入锁ReentrantLock的实现
 */
public class ProducerConsumer02 {

    private static Integer count = 0;
    private static final Integer FULL = 10;

    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    class Producer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //获取锁
                lock.lock();
                try {
                    while (count.equals(FULL)) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                    //唤醒消费者
                    notEmpty.signal();
                } finally {
                    //释放锁
                    lock.unlock();
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
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }


        }
    }


    public static void main(String[] args) {

        ProducerConsumer02 producerConsumer02 = new ProducerConsumer02();
        new Thread(producerConsumer02.new Producer()).start();
        //new Thread(producerConsumer02.new Consumer()).start();
        new Thread(producerConsumer02.new Producer()).start();
        //new Thread(producerConsumer02.new Consumer()).start();
        new Thread(producerConsumer02.new Producer()).start();
        //new Thread(producerConsumer02.new Consumer()).start();
        new Thread(producerConsumer02.new Producer()).start();
        new Thread(producerConsumer02.new Consumer()).start();
        new Thread(producerConsumer02.new Producer()).start();
        new Thread(producerConsumer02.new Consumer()).start();

    }
}
