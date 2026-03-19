package com.example.project1.service;

import com.example.project1.notification.INotificationService;
import com.example.project1.payment.IPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final IPaymentMethod paymentMethod;
    private final INotificationService notificationService;

    @Autowired
    public OrderService(
            @Qualifier("momoPayment") IPaymentMethod paymentMethod,
            @Qualifier("emailNotification") INotificationService notificationService){
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
    }
    public  void processOrder(String customer, String product, double amount) {
        System.out.println("------Xử lý đơn hàng------");
        System.out.println("Khách hàng: " + customer);
        System.out.println("Sản phẩm: " + product);
        System.out.println("Phương thức thanh toán: " + paymentMethod.getMethodName());
        paymentMethod.pay(amount);

        String msg = "Đơn hàng" + product + " trị giá" + amount + " VND đã được xử lý thành công";
        notificationService.sendNotification(customer, msg);
    }


}
