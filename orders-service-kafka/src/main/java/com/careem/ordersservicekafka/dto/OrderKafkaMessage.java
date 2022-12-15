package com.careem.ordersservicekafka.dto;

public class OrderKafkaMessage {
    private String orderNumber;
    private Float price;
    private Integer itemsNumber;
    private String status;

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

    @Override
    public String toString() {
        return "OrderKafkaMessage{" +
                "orderNumber='" + orderNumber + '\'' +
                ", price=" + price +
                ", itemsNumber=" + itemsNumber +
                ", status='" + status + '\'' +
                '}';
    }
}
