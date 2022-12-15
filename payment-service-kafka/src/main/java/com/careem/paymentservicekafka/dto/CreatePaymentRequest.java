package com.careem.paymentservicekafka.dto;

public class CreatePaymentRequest {
    private String orderNumber;
    private Float price;
    private Integer itemsNumber;
    private String status;

    private String paymentNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getItemsNumber() {
        return itemsNumber;
    }

    public void setItemsNumber(Integer itemsNumber) {
        this.itemsNumber = itemsNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }
}


