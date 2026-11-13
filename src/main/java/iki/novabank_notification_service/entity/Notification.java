package iki.novabank_notification_service.entity;

import iki.novabank_notification_service.enums.NotificationStatus;
import iki.novabank_notification_service.enums.NotificationType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String recipientEmail;
    @Column(nullable = false)
    private String recipientPhone;
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;
    @Column(nullable = false)
    private String subject;
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;
    @Column(nullable = false)
    private String transactionReference;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TEXT")
    private String message;
    @PrePersist
    public void prePersist(){
        if(notificationType==null){
            notificationType=NotificationType.EMAIL;
        }
        if(notificationStatus==null){
            notificationStatus=NotificationStatus.SENT;
        }
    }

    public Notification(Long id, String recipientEmail, String recipientPhone, NotificationType notificationType,
                        String subject, NotificationStatus notificationStatus, String transactionReference,
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

    public Notification(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
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
}
