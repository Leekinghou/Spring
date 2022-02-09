package com.spring.ioc.entity;

/**
 * @author: lijinhao
 * @date: 2022/02/07 21:07
 */
public class Apple {
    private String title;
    private String color;
    private String origin;

    public Apple() {
        System.out.println("Apple对象已创建" + this);
    }

    public Apple(String title, String color, String origin) {
        System.out.println("Apple对象通过带参构造方法已创建" + this);
        this.title = title;
        this.color = color;
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
