package com.example.StudySmart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
    Optional<FlashCard> findFlashCardByQuestion(String question);

    Optional<FlashCard> findFlashCardByAnswer(String answer);
}
