package com.example.demo.repository;

import com.example.demo.models.AuthorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorModel, Integer> {

    List<AuthorModel> findAll();

    Optional<AuthorModel> findById(Integer id);


}
