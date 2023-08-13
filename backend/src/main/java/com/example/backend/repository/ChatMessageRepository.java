package com.example.backend.repository;

import com.example.backend.model.ChatMessage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ChatMessageRepository extends ReactiveMongoRepository<ChatMessage, String> {
    @Tailable
    Flux<ChatMessage> findWithTailableCursorByChannelId(String channelId);
}
