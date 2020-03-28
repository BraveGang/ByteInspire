package org.design.creational.prototype;

/**
 * 意图：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * <p>
 * 主要解决：在运行期建立和删除原型。
 * <p>
 * 何时使用：
 * 1、当一个系统应该独立于它的产品创建，构成和表示时。
 * 2、当要实例化的类是在运行时刻指定时，例如，通过动态装载。
 * 3、为了避免创建一个与产品类层次平行的工厂类层次时。
 * 4、当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。
 * <p>
 * 如何解决：利用已有的一个原型对象，快速地生成和原型对象一样的实例。
 * <p>
 * 关键代码：
 * 1、实现克隆操作，在 JAVA 继承 Cloneable，重写 clone()，
 * 2、原型模式同样用于隔离类对象的使用者和具体类型（易变类）之间的耦合关系，它同样要求这些"易变类"拥有稳定的接口。
 */
public class PrototypeTest {

    public static void main(String[] args) {

        ShapeCache.loadCache();

        Shape clonedShape = null;

        try {
            clonedShape = ShapeCache.getShape("1");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = null;
        try {
            clonedShape2 = ShapeCache.getShape("2");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Shape : " + clonedShape2.getType());


        Shape clonedShape3 = null;
        try {
            clonedShape3 = ShapeCache.getShape("3");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Shape : " + clonedShape3.getType());

    }

}
