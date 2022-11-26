package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class ChannelRepository {

    private HashMap<Long, Channel> channelHashMap = new HashMap<>();

    public ChannelRepository() {
        Long channelId = 1L;
        Channel channel = new Channel();
        channel.setChannelId(channelId);
        channel.setChannelName("General");
        channelHashMap.put(channelId, channel);
    }

    public Channel findById(Long channelId) {
        return channelHashMap.get(channelId);
    }

    public Iterable<Channel> findAll() {
        return new ArrayList<>(this.channelHashMap.values());
    }
}
