package com.springboot.domain;

public class MessageEventsDTO {

    private String code;
    private String text;

    public MessageEventsDTO(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
