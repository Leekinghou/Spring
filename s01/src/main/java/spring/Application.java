package spring;

import spring.ioc.Apple;
import spring.ioc.Child;

/**
 * @author: lijinhao
 * @date: 2022/02/07 21:12
 */
public class Application {
    public static void main(String[] args) {
        Apple apple1 = new Apple("红富士", "red", "European");
        Apple apple2 = new Apple("金帅", "yellow", "China");
        Apple apple3 = new Apple("青苹果", "green", "American");

        Child lily = new Child("lily", apple1);
        Child andy = new Child("andy", apple2);
        Child xiaomi = new Child("xiaomi", apple3);
        lily.eat();
        andy.eat();
        xiaomi.eat();
    }
}
