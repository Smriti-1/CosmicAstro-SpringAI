package com.cosmic.controller;

import com.cosmic.model.CosmicRequest;
import com.cosmic.service.CosmicPromptService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cosmic-astro")
public class CosmicController {

    private final ChatClient chatClient;

    public CosmicController(ChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestBody CosmicRequest request) {

        PromptTemplate promptTemplate = CosmicPromptService.template();

        var prompt = promptTemplate.create(Map.of(
                "dob", request.getDateOfBirth(),
                "time", request.getTimeOfBirth(),
                "place", request.getPlaceOfBirth(),
                "question", request.getQuestion()
        ));

        return chatClient.prompt(prompt).call().content();
    }
}
