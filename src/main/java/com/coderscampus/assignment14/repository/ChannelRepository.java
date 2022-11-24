package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ChannelRepository {

    private List<Channel> channels = new ArrayList<>();


    public Optional<Channel> findById(Long channelId) {
        return channels.stream()
                       .filter(channel -> channel.getChannelId().equals(channelId))
                       .findFirst();
    }

    public List<Channel> findAll() {
        return channels;
    }
}
