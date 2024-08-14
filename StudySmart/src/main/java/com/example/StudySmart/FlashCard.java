package com.example.StudySmart;

import jakarta.persistence.*;


@Entity
@Table
public class FlashCard {
    @Id
    @SequenceGenerator(
            name = "FlashCard_sequence",
            sequenceName = "FlashCard_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;

    private String question;

    private String answer;

    public FlashCard() {
    }

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }


}
