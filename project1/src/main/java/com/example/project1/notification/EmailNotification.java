package com.example.project1.notification;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("emailNotification")
@Primary
public class EmailNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("[Email]Gửi tới <" + to + ">: " + message);
    }
}
