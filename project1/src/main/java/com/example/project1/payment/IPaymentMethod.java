package com.example.project1.payment;

public interface IPaymentMethod {
    void pay(double amount);
    String getMethodName();
}
