package com.emmek.menu.entities;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;

public class Order {
    Menu menu;
    Table table;
    int orderNumber;
    OrderState orderState;
    int seats;
    LocalTime orderTime;
    @Value("${order.seat}")
    double seatPrice;
}
