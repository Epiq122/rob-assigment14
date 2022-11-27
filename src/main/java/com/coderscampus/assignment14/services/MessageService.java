package com.coderscampus.assignment14.services;


import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.dto.MessageDto;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private
    ChannelService channelService;
    @Autowired
    private UserService userService;

//    public List<org.apache.logging.log4j.message.Message> getMessagesByChannelId(Long channelId) {
//        return messageRepository.findByChannelId(channelId).orElse(new ArrayList<>());
//    }
//
//    public Message createMessage(Message message) {
//        Optional<Channel> channel = Optional.ofNullable(channelRepository.findById(message.getChannelId()));
//        if (channel.isPresent()) {
//            List<org.apache.logging.log4j.message.Message> messagesByChannel = getMessagesByChannelId(message.getChannelId());
//            messagesByChannel.add((org.apache.logging.log4j.message.Message) message);
//            messageRepository.saveMessages(message.getChannelId(), messagesByChannel);
//
//        }
//        return message;
//    }

    @ResponseBody
    @PostMapping("/messages/{channelId}")
    private void sendMessage(@PathVariable Long channelId, @RequestBody MessageDto messageDto) {
        Message message = new Message();
        Channel channel = channelService.findById(channelId);
        User user = new User();
        user = userService.findByUserId(message.getUserId());
        message.setMessage(messageDto.getMessage());
        message.setUserId(messageDto.getUserId());
        channelService.saveMessage(channelId, message);
    }

}
