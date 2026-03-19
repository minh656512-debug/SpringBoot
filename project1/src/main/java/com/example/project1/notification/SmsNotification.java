package com.example.project1.notification;

import org.springframework.stereotype.Component;

@Component("smsNotification")
public class SmsNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("[SMS]Gửi tới " + to + " : " + message);
    }
}
