package com.example.layeredarchitecture.model;

public class CustomerOrderDetailsDTO {
    private String orderId;
    private String total;
    private String date;
    private String id;
    private String name;

    @Override
    public String toString() {
        return "CustomerOrderDetailsDTO{" +
                "orderId='" + orderId + '\'' +
                ", total='" + total + '\'' +
                ", date='" + date + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CustomerOrderDetailsDTO() {
    }

    public CustomerOrderDetailsDTO(String orderId, String total, String date, String id, String name) {
        this.orderId = orderId;
        this.total = total;
        this.date = date;
        this.id = id;
        this.name = name;
    }
}
