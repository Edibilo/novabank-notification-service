package iki.novabank_notification_service.kafka.service;

import iki.novabank_notification_service.kafka.dto.UserRegistrationEvent;
import iki.novabank_notification_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumerListener {
    private static final Logger log = LoggerFactory.getLogger(NotificationConsumerListener.class);
    private final EmailService emailService;

    public NotificationConsumerListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user-registered-events",groupId = "notification-group")
    public void consumeUserRegisteredEvent(UserRegistrationEvent event){
        try {
            emailService.sendWelcomeEmail(event);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
