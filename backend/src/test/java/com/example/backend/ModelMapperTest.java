package com.example.backend;

import com.example.backend.model.ChatMessage;
import com.example.backend.model.ChatMessageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelMapperTest {

    private ModelMapper mapper;

    @BeforeEach
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Test
    void whenMapDTOWithExactMatch_thenConvertsToEntity() {
        ChatMessageDTO input = new ChatMessageDTO();
        ChatMessage chatMessage = this.mapper.map(input, ChatMessage.class);

        assertEquals(input.getSender(), chatMessage.getSender());
        assertEquals(input.getMessage(), chatMessage.getMessage());
        assertEquals(input.getChannelId(), chatMessage.getChannelId());
    }
}
