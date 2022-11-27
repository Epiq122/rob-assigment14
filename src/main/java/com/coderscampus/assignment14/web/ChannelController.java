package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/")
    public String getRoot() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String getWelcome(ModelMap modelMap) {
        modelMap.put("channel", this.channelService.findById(Long.valueOf(1)));
        return "welcome";
    }

    @GetMapping("/channels/{channelId}")
    public String getChannel(ModelMap modelMap, @PathVariable Long channelId) {
        return "channel";
    }

    @GetMapping("/channels/{channelId}/messages")
    @ResponseBody
    public List<Message> getChannelMessages(@PathVariable Long channelId) {
        return this.channelService.findById(channelId).getMessages();
    }

    @PostMapping("/channels/{channelId}/messages")
    @ResponseBody
    public List<Message> postChannelMessages(@PathVariable Long channelId, @RequestBody Message message) {
        this.channelService.saveMessage(channelId, message);
        return this.channelService.findById(channelId).getMessages();
    }
}

