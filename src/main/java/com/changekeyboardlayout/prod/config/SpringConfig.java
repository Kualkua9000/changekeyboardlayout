package com.changekeyboardlayout.prod.config;

import com.changekeyboardlayout.ChangeKeyboardLayoutBot;
import com.changekeyboardlayout.prod.handler.CallbackQueryHandler;
import com.changekeyboardlayout.prod.handler.MessageHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@AllArgsConstructor
public class SpringConfig {

    private final TelegramConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getBotWebhookPath()).build();
    }

    @Bean
    public ChangeKeyboardLayoutBot springWebhookBot(SetWebhook setWebhook,
                                                    MessageHandler messageHandler,
                                                    CallbackQueryHandler callbackQueryHandler) {
        ChangeKeyboardLayoutBot bot = new ChangeKeyboardLayoutBot(setWebhook, messageHandler, callbackQueryHandler);

        bot.setBotPath(telegramConfig.getBotWebhookPath());
        bot.setBotUsername(telegramConfig.getBotUsername());
        bot.setBotToken(telegramConfig.getBotToken());

        return bot;
    }
}
