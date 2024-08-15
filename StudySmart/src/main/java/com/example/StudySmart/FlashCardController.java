package com.example.StudySmart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/FlashCards")
@CrossOrigin("*")
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

    @GetMapping(path = "{id}")
    public ResponseEntity<FlashCard> getFlashCard(@PathVariable long id) {
        FlashCard flashCard = flashCardService.getFlashCardById(id);
        if (flashCard == null) {
            return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FlashCard>(flashCard, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlashCard> addFlashCard(@RequestBody FlashCard card) {
        return new ResponseEntity<FlashCard>(flashCardService.addFlashCard(card), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<FlashCard> updateFlashCard(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        return new ResponseEntity<FlashCard>(flashCardService
                .updateFlashCard(id, body.getOrDefault("question",
                        null), body.getOrDefault("answer",
                        null)),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<FlashCard> deleteFlashCard(@PathVariable Long id) {
        return new ResponseEntity<FlashCard>(flashCardService.deleteFlashCard(id), HttpStatus.OK);
    }
}
