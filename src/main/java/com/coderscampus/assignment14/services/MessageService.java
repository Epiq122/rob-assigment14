package com.coderscampus.assignment14.services;


import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private
    ChannelService channelService;

    public List<Message> getMessagesByChannelId(Long channelId) {
        return messageRepository.findByChannelId(channelId).orElse(new ArrayList<>());
    }

    public Message createMessage(Long channelId, Message message) {
        Optional<Channel> channel = Optional.ofNullable(channelRepository.findById(message.getChannelId()));
        if (channel.isPresent()) {
            List<Message> messagesByChannel = getMessagesByChannelId(message.getChannelId());
            messagesByChannel.add(message);
            messageRepository.saveMessages(message.getChannelId(), messagesByChannel);

        }
        return message;
    }


}
