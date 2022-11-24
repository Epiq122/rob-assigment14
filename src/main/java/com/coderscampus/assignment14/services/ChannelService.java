package com.coderscampus.assignment14.services;


import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    public Channel findById(Long channelId) {
        return channelRepository.findById(channelId).orElse(new Channel());
    }

    public List<Channel> findAll() {
        return channelRepository.findAll();
    }
}
