package com.spring.ioc.entity;

/**
 * @author: lijinhao
 * @date: 2022/02/16 17:57
 */
public class Order {
    private Float price;
    private Integer quantity;
    private Float total;

    public Order() {
        System.out.println("创建Order对象," + this);
    }

    public void init(){
        total = price * quantity;
    }

    public void pay(){
        System.out.println("订单金额为：" + total);
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        System.out.println("设置price：" + price);
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        System.out.println("设置quantity：" + price);
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void destroy(){
        System.out.println("释放与订单对象相关的资源");
    }
}
