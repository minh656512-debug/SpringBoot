package com.example.project1.payment;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bankTransferPayment")
@Primary
public class BankTransferPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("[Bank Transfer]Đã chuyển khoản " + amount + " VND qua ngân hàng");
    }

    @Override
    public String getMethodName() {
        return "Bank Transfer";
    }

}
