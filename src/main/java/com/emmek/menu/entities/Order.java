package com.emmek.menu.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Random;

@Component
@Data
@PropertySource("application.properties")
public class Order {
    Menu menu;
    Table table;
    int orderNumber;
    OrderState orderState;
    int seats;
    LocalTime orderTime;
    @Value("${order.seat}")
    double seatPrice;

    public void setTable(Table table) {
        Random random = new Random();
        table.setAvailable(false);
        this.table = table;
        seats = random.nextInt(table.getSeats()) + 1;
    }

}
