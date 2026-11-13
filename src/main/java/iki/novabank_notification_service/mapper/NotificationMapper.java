package iki.novabank_notification_service.mapper;

import iki.novabank_notification_service.dto.NotificationDto;
import iki.novabank_notification_service.entity.Notification;

public class NotificationMapper {
    public static Notification mapToNotification(NotificationDto notificationDto){
        Notification notification=new Notification();
        notification.setSubject(notificationDto.getSubject());
        notification.setRecipientEmail(notificationDto.getRecipientEmail());
        notification.setNotificationType(notificationDto.getNotificationType());
        notification.setId(notificationDto.getId());
        notification.setMessage(notificationDto.getMessage());
        notification.setNotificationStatus(notificationDto.getNotificationStatus());
        notification.setRecipientPhone(notificationDto.getRecipientPhone());
        notification.setTransactionReference(notificationDto.getTransactionReference());
        return notification;
    }

    public static NotificationDto mapToNotificationDto(Notification notification){
        NotificationDto notificationDto=new NotificationDto();
        notificationDto.setId(notification.getId());
        notificationDto.setMessage(notification.getMessage());
        notificationDto.setNotificationStatus(notification.getNotificationStatus());
        notificationDto.setNotificationType(notification.getNotificationType());
        notificationDto.setRecipientEmail(notification.getRecipientEmail());
        notificationDto.setRecipientPhone(notification.getRecipientPhone());
        notificationDto.setSubject(notification.getSubject());
        notificationDto.setTransactionReference(notification.getTransactionReference());
        return notificationDto;
    }
}
