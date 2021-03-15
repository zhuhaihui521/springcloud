package com.mall.huitop.dto;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-15 20:44
 */

public class OrderDto {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public OrderDto(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
