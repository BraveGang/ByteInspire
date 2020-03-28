package org.design.behavioral.observer;


/**
 * 观察者模式
 * <p>
 * 意图：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * <p>
 * 主要解决：一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。
 * <p>
 * 何时使用：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
 * <p>
 * 如何解决：使用面向对象技术，可以将这种依赖关系弱化。
 * <p>
 * 关键代码：在抽象类里有一个 ArrayList 存放观察者们。
 */
public class ObserverTest {

    public static void main(String[] args) {

        Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }

}
