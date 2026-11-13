package iki.novabank_notification_service.service;

import iki.novabank_notification_service.kafka.dto.UserRegistrationEvent;

public interface EmailService {

    void sendWelcomeEmail(UserRegistrationEvent event);

    void sendCreditAlert();

    void sendDebitAlert();
}
