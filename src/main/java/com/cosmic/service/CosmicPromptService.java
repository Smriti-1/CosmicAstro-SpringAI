package com.cosmic.service;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class CosmicPromptService {

    public static PromptTemplate template() {
        String prompt = """
                You are a professional astrologer.
                
                User Details:
                - Date of Birth: {dob}
                - Time of Birth: {time}
                - Place of Birth: {place}
                
                Question:
                {question}
                
                Give a clear, practical, and helpful astrological answer.
                """;

        return new PromptTemplate(prompt);
    }

}
