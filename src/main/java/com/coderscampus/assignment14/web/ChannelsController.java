package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChannelsController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        model.addAttribute("channels", channelService.findAll());
        return "welcome";
    }
}
