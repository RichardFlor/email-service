package com.richard.email_service.core.cases;

public interface EmailSenderUseCase {
    void sendEmail(String toEmail, String subject, String body);
}
