package com.changekeyboardlayout.prod.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class TelegramConfig {

    @Value("telegram.token")
    private String botToken;

    @Value("telegram.user")
    private String botUsername;

    @Value("telegram.webhook-path")
    private String botWebhookPath;

}
