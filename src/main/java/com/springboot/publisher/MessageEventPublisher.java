package com.springboot.publisher;

import com.springboot.events.MessageEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MessageEventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void doStuffAndPublishAnEvent(final String code, final String text){
        MessageEvents events = new MessageEvents(this, code, text);
        eventPublisher.publishEvent(events);
    }
}
