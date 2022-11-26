//package com.coderscampus.assignment14.web;
//
//
//import com.coderscampus.assignment14.domain.Message;
//import com.coderscampus.assignment14.services.ChannelService;
//import com.coderscampus.assignment14.services.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class MessagesController {
//    @Autowired
//    private MessageService messageService;
//    @Autowired
//    private ChannelService channelService;
//
//    @GetMapping("/channels/{channelId}/messages")
//    @ResponseBody
//    public List<Message> getMessagesByChannelId(@PathVariable Long channelId) {
//        return channelService.findById(channelId).getMessages();
//    }
//
//    @PostMapping("/channels/{channelId}/messages")
//    @ResponseBody
//    public Message createMessage(@PathVariable Long channelId, @RequestBody Message message) {
//        channelService.saveMessage(channelId, message);
//        return channelService.findById(channelId)
//                             .getMessages()
//                             .get(channelService.findById(channelId).getMessages().size() - 1);
//    }
//
//
//}
