package com.emmek.menu.utils;

import com.emmek.menu.MenuApplication;
import com.emmek.menu.decorator.*;
import com.emmek.menu.entities.Drink;
import com.emmek.menu.entities.Menu;
import com.emmek.menu.entities.Order;
import com.emmek.menu.entities.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MenuApplication.class);
//        Menu menu = context.getBean(Menu.class);

        Menu menu = context.getBean(Menu.class);
        menu.printMenu();


        Consumation pizza4 = context.getBean(PizzaMargherita.class);
        Consumation pizza5 = context.getBean(PizzaMargherita.class);

        Menu menu2 = new Menu(List.of(pizza4, pizza5),
                List.of(new Drink("Coca Cola", 0.25, 2),
                        new Drink("Fanta", 0.33, 2.5)),
                List.of());


        Order order = context.getBean(Order.class);
        order.setTable(context.getBean(Table.class));
        order.setMenu(menu2);
        order.printOrder();
    }


    public void old() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MenuApplication.class);
//        Menu menu = context.getBean(Menu.class);


        Consumation pizza = context.getBean(PizzaMargherita.class);
//        Consumation pizza2 = context.getBean(PizzaMargherita.class);
        Consumation pizza3 = context.getBean(PizzaMargherita.class);
        Consumation pizza2 = context.getBean(ExtraAnanasDecorator.class);
        pizza2 = new ExtraProsciuttoDecorator(pizza2);
        pizza3 = context.getBean(ExtraSalameDecorator.class);
//        pizza2 = new ExtraProsciuttoDecorator(pizza2);
//        menu.addPizza(pizza2);

        Menu menu = new Menu(List.of(pizza, pizza2, pizza3),
                List.of(),
                List.of(context.getBean(ExtraSalameDecorator.class),
                        context.getBean(ExtraProsciuttoDecorator.class),
                        context.getBean(ExtraAnanasDecorator.class)));
        menu.printMenu();
    }
}
