package com.example.demo.services;

import com.example.demo.NotFoundException;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel findUserById(int id) {
        return this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id: " + id + " not found!"));
    }

    public UserModel saveUser(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

    public UserModel updateUser(UserModel userModel) {
        checkForUser(userModel.getId());

        return this.userRepository.save(userModel);
    }

    public UserModel deleteUser(int id) {
        UserModel userModel = this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id: " + id + " not found!"));
        this.userRepository.delete(userModel);
        return userModel;
    }

    private void checkForUser(Integer userId) {
        if (!this.userRepository.existsById(userId))
            throw new NotFoundException("User with id: " + userId + " not found!");
    }


}
