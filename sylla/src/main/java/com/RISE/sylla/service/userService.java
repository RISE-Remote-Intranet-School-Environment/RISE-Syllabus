package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.userModel;
import com.RISE.sylla.repository.userRepository;
import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    userRepository userRepository;

    // CREATE
    public userModel createUser(userModel user) {
        return userRepository.save(user);
    }

    // READ
    public List<userModel> getUsers() {
        return userRepository.findAll();
    }

    //READ by id
    public Optional<userModel> getUserById(Long userId){return userRepository.findById(userId);}

    // DELETE
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // UPDATE
    public userModel updateUser(Long userId, userModel userDetails) {
        userModel user = userRepository.findById(userId).get();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmailId(userDetails.getEmailId());

        return userRepository.save(user);
    }
}
