package iki.novabank_notification_service.dto;

import iki.novabank_notification_service.enums.NotificationStatus;
import iki.novabank_notification_service.enums.NotificationType;

import java.time.LocalDateTime;

public class NotificationDto {
    private Long id;
    private String recipientEmail;
    private String recipientPhone;
    private NotificationType notificationType;
    private String subject;
    private NotificationStatus notificationStatus;
    private String transactionReference;
    private LocalDateTime createdAt;
    private String message;

    public NotificationDto(){

    }

    public NotificationDto(Long id, String recipientEmail, String recipientPhone,
                           NotificationType notificationType, String subject,
                           NotificationStatus notificationStatus, String transactionReference,
                           LocalDateTime createdAt, String message) {
        this.id = id;
        this.recipientEmail = recipientEmail;
        this.recipientPhone = recipientPhone;
        this.notificationType = notificationType;
        this.subject = subject;
        this.notificationStatus = notificationStatus;
        this.transactionReference = transactionReference;
        this.createdAt = createdAt;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
