package com.example.project1.payment;

import org.springframework.stereotype.Component;

@Component("momoPayment")
public class MoMoPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("[MoMo]Đã thanh toán" + amount + " VND qua ví MoMo");
    }

    @Override
    public String getMethodName() {
        return "MoMo";
    }
}
