package com.example.StudySmart;

import jakarta.transaction.Transactional;
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

    @Transactional
    public FlashCard updateFlashCard(long id, String question, String answer) {
        FlashCard flashCardToUpdate = flashCardRepository.findById(id).orElseThrow(() -> new IllegalStateException("Flash card not found"));

        if (question != null && !question.equals(flashCardToUpdate.getQuestion())) {
            flashCardToUpdate.setQuestion(question);
        }
        if (answer != null && !answer.equals(flashCardToUpdate.getAnswer())) {
            flashCardToUpdate.setAnswer(answer);
        }

        return flashCardToUpdate;
    }
}
