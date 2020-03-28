package org.design.creational.factory;

/**
 * 工厂模式
 * <p>
 * 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * <p>
 * 主要解决：主要解决接口选择的问题。
 * <p>
 * 何时使用：我们明确地计划不同条件下创建不同实例时。
 * <p>
 * 如何解决：让其子类实现工厂接口，返回的也是一个抽象的产品。
 * <p>
 * 关键代码：创建过程在其子类执行。
 */
public class FactoryTest {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();

    }
}
