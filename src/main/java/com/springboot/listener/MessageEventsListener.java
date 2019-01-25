package com.springboot.listener;

import com.springboot.events.MessageEvents;
import com.springboot.translate.TranslateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageEventsListener implements ApplicationListener<MessageEvents> {

    @Autowired
    private TranslateMessageService translate;

    @Override
    public void onApplicationEvent(MessageEvents messageEvents) {
      System.out.println(translate.translate(messageEvents.getCode(), messageEvents.getText()));
    }
}