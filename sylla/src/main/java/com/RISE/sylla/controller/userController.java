package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.userModel;
import com.RISE.sylla.service.userService;

@RestController
@RequestMapping("/api")
public class userController {
    @Autowired
    userService userService;

    @RequestMapping(value="/users", method= RequestMethod.POST)
    public userModel createUser(@RequestBody userModel user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<userModel> readUsers() {
        return userService.getUser();
    }

    @RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
    public userModel readUsers(@PathVariable(value = "userId") Long id, @RequestBody userModel userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "userId") Long id) {
        userService.deleteUser(id);
    }

}