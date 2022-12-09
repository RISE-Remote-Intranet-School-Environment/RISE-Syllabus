package com.RISE.sylla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class orderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private long orderId;

    @Column(name="student")
    private Long student;

    @Column(name="date")
    private String date;

    @Column(name="price")
    private int price;

    @Column(name="state")
    private String state;

    public long getOrderID() {
        return orderId;
    }

    public void setOrderID(long orderId) {
        this.orderId = orderId;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
