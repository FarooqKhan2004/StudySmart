package com.example.StudySmart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FlashCardConfig {
    @Bean
    CommandLineRunner commandLineRunner(FlashCardRepository flashCardRepository) {
        return args -> {
            FlashCard card1 = new FlashCard("What is 1 + 1", "2");

            FlashCard card2 = new FlashCard("What is 2 + 2", "3");

            flashCardRepository.saveAll(List.of(card1, card2));
        };
    }
}
