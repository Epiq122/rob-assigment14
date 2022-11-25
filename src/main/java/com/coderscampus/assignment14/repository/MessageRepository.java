package com.coderscampus.assignment14.repository;


import com.coderscampus.assignment14.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository

public class MessageRepository {
    private final Map<Long, List<Message>> messages = new HashMap<>();

    public Optional<List<Message>> findByChannelId(Long channelId) {
        List<Message> messagesByChannel = messages.get(channelId);
        return Optional.ofNullable(messagesByChannel);
    }

    public void saveMessages(Long channelId, List<Message> messagesByChannel) {
        messages.put(channelId, messagesByChannel);
    }
}
