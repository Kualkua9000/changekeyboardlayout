package com.changekeyboardlayout.prod;

import org.springframework.stereotype.Controller;

@Controller("/message")
public class MessageController {


    public String getMessage(String message) {
        return message + " Hello pidor!";
    }
}
