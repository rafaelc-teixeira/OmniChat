package com.example.backend.controller;

import com.example.backend.model.ChatMessage;
import com.example.backend.model.ChatMessageDTO;
import com.example.backend.repository.ChatMessageRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin(value = { "*" },
        maxAge = 900
)

@RestController
public class ChatMessageController {
    @Autowired
    private ChatMessageRepository chatMessageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/chats")
    @ResponseStatus(HttpStatus.CREATED)
    public void postChat(@Valid @RequestBody ChatMessageDTO chatMessageDTO) {
        ChatMessage chatMessage = modelMapper.map(chatMessageDTO, ChatMessage.class);
        chatMessageRepo.save(chatMessage).subscribe();
    }

    @GetMapping(value = "/chats/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatMessage> streamMessages(@RequestParam String channelId) {
        return chatMessageRepo.findWithTailableCursorByChannelId(channelId);
    }
}
