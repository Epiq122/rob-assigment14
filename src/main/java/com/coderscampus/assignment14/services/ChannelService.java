package com.coderscampus.assignment14.services;


import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<Channel> findAll() {
        return this.channelRepository.findAll();
    }

    public Channel findById(Long channelId) {
        return this.channelRepository.findById(channelId);
    }

    public void saveMessage(Long channelId, Message message) {
        this.channelRepository.findById(channelId).getMessages().add(message);
    }
}
