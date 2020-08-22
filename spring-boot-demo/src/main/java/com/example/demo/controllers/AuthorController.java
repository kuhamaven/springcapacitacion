package com.example.demo.controllers;

import com.example.demo.models.AuthorModel;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorModel getAuthorModel(@PathVariable Integer id) {
        return this.authorService.findAuthorById(id);
    }

    @PostMapping()
    public ResponseEntity createAuthor(@Valid @RequestBody AuthorModel authorModel) {
        return ResponseEntity.ok(this.authorService.saveAuthor(authorModel));
    }

    @PutMapping()
    public ResponseEntity updateAuthor(@Valid @RequestBody AuthorModel authorModel) {
        return ResponseEntity.ok(this.authorService.updateAuthor(authorModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Integer id) {
        return ResponseEntity.ok(this.authorService.deleteAuthor(id));
    }
}
