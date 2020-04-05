package org.thread;


/**
 * 实现生产者消费者模型
 * wait()和notify()方法的实现
 */
public class ProducerConsumer01 {

    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static final String LOCK = "lock";


    class Producer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count.equals(FULL)) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }


        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception ignored) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }


        }
    }

    public static void main(String[] args) {

        ProducerConsumer01 producerConsumer01 = new ProducerConsumer01();
        new Thread(producerConsumer01.new Producer()).start();
        //new Thread(producerConsumer01.new Consumer()).start();
        new Thread(producerConsumer01.new Producer()).start();
        //new Thread(producerConsumer01.new Consumer()).start();
        new Thread(producerConsumer01.new Producer()).start();
        //new Thread(producerConsumer01.new Consumer()).start();
        new Thread(producerConsumer01.new Producer()).start();
        // new Thread(producerConsumer01.new Consumer()).start();
        new Thread(producerConsumer01.new Producer()).start();
        new Thread(producerConsumer01.new Consumer()).start();

    }


}
