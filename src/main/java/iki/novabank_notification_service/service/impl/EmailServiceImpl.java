package iki.novabank_notification_service.service.impl;

import iki.novabank_notification_service.dto.NotificationDto;
import iki.novabank_notification_service.entity.Notification;
import iki.novabank_notification_service.enums.NotificationStatus;
import iki.novabank_notification_service.enums.NotificationType;
import iki.novabank_notification_service.kafka.dto.UserRegistrationEvent;
import iki.novabank_notification_service.repository.NotificationRepository;
import iki.novabank_notification_service.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final NotificationRepository notificationRepository;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine,
                            NotificationRepository notificationRepository) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.notificationRepository = notificationRepository;
    }

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void sendWelcomeEmail(UserRegistrationEvent event) {
    try {
        Context context=new Context();
        context.setVariable("firstName",event.getFirstName());
        context.setVariable("lastName",event.getLastName());
        context.setVariable("email",event.getEmail());
        context.setVariable("bankName",event.getBankName());
        context.setVariable("accountNumber",event.getAccountNumber());
        String htmlTemplate=templateEngine.process("welcome-html",context);

        Notification notification=new Notification();
        notification.setNotificationType(NotificationType.EMAIL);
        notification.setRecipientEmail(event.getEmail());
        notification.setSubject("Welcome to "+event.getBankName()+" Your Account is ready !");
        notification.setMessage(htmlTemplate);
        notification.setNotificationStatus(NotificationStatus.SENT);

        //send the email out
        sendEmailOut(event.getEmail(), notification.getSubject(), htmlTemplate);

        //save to database
        notificationRepository.save(notification);

    } catch (Exception e) {
        Notification notification=new Notification();
        notification.setNotificationType(NotificationType.EMAIL);
        notification.setRecipientEmail(event.getEmail());
        notification.setSubject("Welcome to "+event.getBankName()+" Your Account is ready !");
        notification.setMessage("Failed to send Message");
        notification.setNotificationStatus(NotificationStatus.FAILED);
        notificationRepository.save(notification);
        throw new RuntimeException("Error in sending Message !");
    }
    }

    @Override
    public void sendCreditAlert() {

    }

    @Override
    public void sendDebitAlert() {

    }

    private void sendEmailOut(String recipientEmail, String subject, String emailTemplate) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                true,
                "UTF-8"

        );
        helper.setFrom(fromEmail);
        helper.setTo(recipientEmail);
        helper.setSubject(subject);
        helper.setText(emailTemplate, true);

        javaMailSender.send(mimeMessage);
    }
}
