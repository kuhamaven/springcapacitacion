package com.example.demo.repository;

import com.example.demo.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    List<UserModel> findAll();

    Optional<UserModel> findById(Integer id);


}
