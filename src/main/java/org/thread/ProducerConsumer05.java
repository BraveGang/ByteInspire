package org.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 实现生产者消费者模型
 * 管道输入输出流PipedInputStream和PipedOutputStream实现
 */
public class ProducerConsumer05 {

    final PipedInputStream pis = new PipedInputStream();
    final PipedOutputStream pos = new PipedOutputStream();

    {
        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class Producer implements Runnable {

        @Override
        public void run() {

            try {
                while (true) {
                    Thread.sleep(1000);
                    int num = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "生产者生产了一个数字，该数字为： " + num);
                    pos.write(num);
                    pos.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    class Consumer implements Runnable {

        @Override
        public void run() {

            try {
                while (true) {
                    Thread.sleep(1000);
                    int num = pis.read();
                    System.out.println("消费者消费了一个数字，该数字为：" + num);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {

        ProducerConsumer05 producerConsumer05 = new ProducerConsumer05();
        new Thread(producerConsumer05.new Producer()).start();
        //new Thread(producerConsumer05.new Consumer()).start();
        new Thread(producerConsumer05.new Producer()).start();
        //new Thread(producerConsumer05.new Consumer()).start();
        new Thread(producerConsumer05.new Producer()).start();
        //new Thread(producerConsumer05.new Consumer()).start();
        new Thread(producerConsumer05.new Producer()).start();
        new Thread(producerConsumer05.new Consumer()).start();
        new Thread(producerConsumer05.new Producer()).start();
        new Thread(producerConsumer05.new Consumer()).start();

    }
}
