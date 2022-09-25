package com.changekeyboardlayout.prod.controller;

import com.changekeyboardlayout.prod.service.ChangeKeyboardLayoutBotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@AllArgsConstructor
public class WebhookController {
    private final ChangeKeyboardLayoutBotService changeKeyboardLayoutBotService;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return changeKeyboardLayoutBotService.onWebhookUpdateReceived(update);
    }
}
