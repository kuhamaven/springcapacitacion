package com.example.demo;

import com.example.demo.models.AuthorModel;
import com.example.demo.models.UserModel;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.AuthorService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class OnStart {

    private final AuthorService authorService;

    @Autowired
    public OnStart(AuthorService authorService) {
        this.authorService = authorService;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        try {

        } catch (Exception ignored) {
        }
    }

}
