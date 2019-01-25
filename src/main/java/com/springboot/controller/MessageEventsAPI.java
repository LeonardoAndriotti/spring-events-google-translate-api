package com.springboot.controller;

import com.springboot.domain.MessageEventsDTO;
import com.springboot.events.MessageEvents;
import com.springboot.publisher.MessageEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
public class MessageEventsAPI {

    @Autowired
    private MessageEventPublisher publisher;

    @PostMapping(value = "/message")
    public void sendMessage(@RequestBody MessageEventsDTO events){
        if(nonNull(events.getCode()) && nonNull(events.getText())){
            this.publisher.doStuffAndPublishAnEvent(events.getCode(), events.getText());
        }
    }
}
