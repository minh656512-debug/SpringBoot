package com.example.project1.payment;

import org.springframework.stereotype.Component;

@Component("cashPayment")
public class CashPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("[Cash]Đã thanh toán " + amount + " VND bằng tiền mặt");
    }

    @Override
    public String getMethodName() {
        return "Cash";
    }
}
