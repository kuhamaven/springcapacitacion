package com.example.demo.services;

import com.example.demo.NotFoundException;
import com.example.demo.models.AuthorModel;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorModel findAuthorById(int id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Author with id: " + id + " not found!"));
    }

    public AuthorModel saveAuthor(AuthorModel authorModel) {
        return this.authorRepository.save(authorModel);
    }

    public AuthorModel updateAuthor(AuthorModel authorModel) {
        checkForAuthor(authorModel.getId());
        return this.authorRepository.save(authorModel);
    }

    public AuthorModel deleteAuthor(int id) {
        AuthorModel authorModel = this.authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Author with id: " + id + " not found!"));
        this.authorRepository.delete(authorModel);
        return authorModel;
    }

    private void checkForAuthor(Integer authorId) {
        if (!this.authorRepository.existsById(authorId))
            throw new NotFoundException("Author with id: " + authorId + " not found!");
    }


}
