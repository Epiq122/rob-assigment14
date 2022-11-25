package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessagesController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/messages/{channelId}")
    public List<Message> getMessagesByChannelId(@PathVariable Long channelId) {
        return messageService.getMessagesByChannelId(channelId);
    }

    @PostMapping("/messages")
    public Message postMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

}
