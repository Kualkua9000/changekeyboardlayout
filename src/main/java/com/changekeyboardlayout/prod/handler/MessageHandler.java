package com.changekeyboardlayout.prod.handler;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MessageHandler {

    public BotApiMethod<?> answerMessage(Message message) {

        String chatId = message.getChatId().toString();
        String inputText = message.getText();

        if (inputText == null) {
            throw new IllegalArgumentException();
        } else if (inputText.equals("")) {
            return new SendMessage(chatId, "Просто введите текст, который нужно " +
                    "перевести в другую раскладку в поле сообщения и нажмите Enter");
        } else if (inputText.equals("/help")) {
            return new SendMessage(chatId, "Просто введите текст, который нужно " +
                    "перевести в другую раскладку в поле сообщения и нажмите Enter");
        } else {
            return new SendMessage(chatId, changeMessageLayout(inputText));
        }
    }

    public String changeMessageLayout(String message) {
        String[] arr = message.split("");
        Map<String, String> dictionary = new LiteralDictionary().getDictionary();
        for (int i = 0; i < arr.length; i++) arr[i] = dictionary.get(arr[i]);
        StringBuilder result = new StringBuilder();
        for(String val:arr) result.append(val);
        return result.toString();
    }
}
