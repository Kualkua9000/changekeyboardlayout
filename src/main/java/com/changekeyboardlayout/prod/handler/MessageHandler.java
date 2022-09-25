package com.changekeyboardlayout.prod.handler;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MessageHandler {

    public BotApiMethod<?> answerMessage(Message message) {

        String chatId = message.getChatId().toString();
        String inputText = message.getText();

        if (inputText == null) {
            throw new IllegalArgumentException();
        } else if (inputText.equals("/start")) {
            return new SendMessage(chatId, "Hello!");
        } else if (inputText.equals("/reverse")) {
            return new SendMessage(chatId, "Reverse!");
        } else {
            return new SendMessage(chatId, "omg, what's happening? (ya hz)");
        }
    }

}
