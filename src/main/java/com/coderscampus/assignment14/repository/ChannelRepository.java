package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ChannelRepository {
    private final HashMap<Long, Channel> channelMap = new HashMap<Long, Channel>();

    public ChannelRepository() {
        Long channelId = 1L;
        Channel channel = new Channel();
        channel.setChannelId(channelId);
        channel.setChannelName("General");
        this.channelMap.put(channelId, channel);
    }

    public Channel findById(Long channelId) {
        return this.channelMap.get(channelId);
    }

    public List<Channel> findAll() {
        return new ArrayList<>(this.channelMap.values());
    }
}
