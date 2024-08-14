package com.example.StudySmart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;

    @Autowired
    public FlashCardService(FlashCardRepository flashCardRepository) {
        this.flashCardRepository = flashCardRepository;
    }

    public List<FlashCard> getAllFlashCards() {
        return flashCardRepository.findAll();
    }

    public FlashCard addFlashCard(FlashCard flashCard) {
        if(flashCardRepository.findFlashCardByAnswer(flashCard.getAnswer()).isPresent() &&
        flashCardRepository.findFlashCardByQuestion(flashCard.getQuestion()).isPresent()) {
            throw new IllegalStateException("Flash card already exists");
        }
        flashCardRepository.save(flashCard);
        return flashCard;
    }
}
