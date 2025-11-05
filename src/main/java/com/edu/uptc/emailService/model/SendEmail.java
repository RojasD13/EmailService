package com.edu.uptc.emailService.model;

import jakarta.servlet.http.HttpServletRequest;

public interface SendEmail {
    void sendEmail(HttpServletRequest request);
}
