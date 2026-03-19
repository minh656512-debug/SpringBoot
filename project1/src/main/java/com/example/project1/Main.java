package com.example.project1;

import com.example.project1.notification.INotificationService;
import com.example.project1.payment.IPaymentMethod;
import com.example.project1.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService oderService = ctx.getBean(OrderService.class);
        oderService.processOrder("Nguyen Van A", "Laptop Dell XPS 13", 30_000_000);

        IPaymentMethod cash = ctx.getBean("cashPayment", IPaymentMethod.class);
        INotificationService email = ctx.getBean("emailNotification", INotificationService.class);
        OrderService cashOrder = new OrderService(cash, email);
        cashOrder.processOrder("Le Thi B", "Smartphone Samsung Galaxy S21", 15_000_000);
}
}
