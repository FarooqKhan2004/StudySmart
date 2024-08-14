package com.example.StudySmart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/FlashCards")
public class FlashCardController {

    private final FlashCardService flashCardService;

    @Autowired
    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @GetMapping
    public ResponseEntity<List<FlashCard>> getFlashCards() {
        return new ResponseEntity<List<FlashCard>>(flashCardService.getAllFlashCards(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlashCard> addFlashCard(@RequestBody Map<String, String> body) {
        FlashCard flashCardToAdd = new FlashCard(body.get("question"), body.get("answer"));
        return new ResponseEntity<FlashCard>(flashCardService.addFlashCard(flashCardToAdd), HttpStatus.CREATED);
    }
}
