package com.pluralsight.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private LocalDateTime timeStamp;
    private List<Orderable> items;

    public Order(String orderId, LocalDateTime timeStamp, List<Orderable> items) {
        this.orderId = orderId;
        this.timeStamp = timeStamp;
        this.items = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void addItem(Orderable item){
        items.add(item);
    }
    //todo
    // calculate total and generate receipt
}
