package com.springboot.events;

import org.springframework.context.ApplicationEvent;

public class MessageEvents extends ApplicationEvent {

    private String code;
    private String text;

    public MessageEvents(Object source, String code, String text) {
        super(source);
        this.code = code;
        this.text = text;
    }

    /*Getters and Setters*/

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
