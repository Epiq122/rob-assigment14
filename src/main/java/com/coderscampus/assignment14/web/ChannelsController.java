package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.services.ChannelService;
import com.coderscampus.assignment14.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChannelsController {
    @Autowired
    ChannelService channelService;
    @Autowired
    private MessageService messageService;


    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        model.addAttribute("channels", channelService.findAll());
        return "welcome";
    }

    @GetMapping("/channels/{channelId}")
    public String getChannel(@PathVariable Long channelId, ModelMap model) {
        Channel channels = channelService.findById(channelId);
        model.addAttribute("channel", channels);
        model.addAttribute("selectedChannel", channelId);
        List<Message> messages = messageService.getMessagesByChannelId(channelId);
        model.addAttribute("messages", messages);
        return "channel";

    }

    @GetMapping("/channels/{channelId}/messages")
    @ResponseBody
    public List<Message> getMessagesByChannelId(@PathVariable Long channelId) {
        return channelService.findById(channelId).getMessages();
    }

    @PostMapping("/channels/{channelId}/messages")
    @ResponseBody
    public Message createMessage(@PathVariable Long channelId, @RequestBody Message message) {
        channelService.saveMessage(channelId, message);
        return (Message) channelService.findById(channelId)
                                       .getMessages();

    }

}
//Autowired
//private ChannelService channelService;
//@Autowired
//private MessageService messageService;
//
//@GetMapping("/welcome")
//public String welcome(ModelMap model) {
//        model.addAttribute("channels", channelService.findAll());
//        return "welcome";
//        }
//
