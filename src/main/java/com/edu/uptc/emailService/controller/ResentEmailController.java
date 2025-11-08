package com.edu.uptc.emailService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.uptc.emailService.dto.EmailNotificationEvent;
import com.edu.uptc.emailService.model.SendEmail;

@Controller
public class ResentEmailController {

    private final SendEmail sendEmail;

    public ResentEmailController(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @PostMapping("/send-email")
    public void sendEmail(EmailNotificationEvent event) {
        sendEmail.sendEmailFromEvent(event);
    }

}
