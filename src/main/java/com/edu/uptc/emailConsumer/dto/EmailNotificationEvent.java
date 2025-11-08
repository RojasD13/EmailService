package com.edu.uptc.emailConsumer.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailNotificationEvent implements Serializable {
    
    private String userEmail;
    private String clientIp;
    private String httpMethod;
    private String requestUri;
    private LocalDateTime timestamp;

}
