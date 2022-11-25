package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ChannelRepository {

    private List<Channel> channels = new ArrayList<>();


    public ChannelRepository() {
        Channel general = new Channel();
        general.setChannelId(1L);
        general.setChannelName("General");
        channels.add(general);
    }

    public Optional<Channel> findById(Long channelId) {
        return channels.stream()
                       .filter(channel -> channel.getChannelId().equals(channelId))
                       .findAny();
    }

    public List<Channel> findAll() {
        return channels;
    }


}
