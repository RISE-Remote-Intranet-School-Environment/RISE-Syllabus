package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.userModel;
import com.RISE.sylla.service.userService;

/**
 * This Class redirects '/user' to the apporpriate methods defined in the userService
 */

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userService userService;

    /**
     * POST method '/user/users' creating users with params
     * body need to look like : {
     *      userId: 1
     *      firstname: test
     *      lastname: test
     *      email:test
     *      role: test
     *      matricule : 1
     *      trigram : test
     * }
     * @param user param user object
     * @return new posted user
     */
    @RequestMapping(value="/users", method= RequestMethod.POST)
    public userModel createUser(@RequestBody userModel user) {
        return userService.createUser(user);
    }

    /**
     * GET method '/user/users' returning users
     * @return list of all users
     */
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<userModel> readUsers() {
        return userService.getUsers();
    }

    /**
     * GET method '/user/users/{userId}' returning user corresponding to id as param
     * @param id of the user to be returned
     * @return If it exist, the user
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
    public Optional<userModel> readUserById(@PathVariable(value = "userId") Long id) {
        return userService.getUserById(id);
    }

    /**
     * PUT method '/user/users/{userId}' updating the user with the specified id
     * body need to look like : {
     *          userId: 1
     *          firstname: test
     *          lastname: test
     *          email:test
     *          role: test
     *          matricule : 1
     *          trigram : test
     *    }
     *
     * @param id of the user to modify
     * @param userDetails details to modify with variables
     * @return the user modified
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
    public userModel updateUsers(@PathVariable(value = "userId") Long id, @RequestBody userModel userDetails) {
        return userService.updateUser(id, userDetails);
    }

    /**
     * DELETE method 'user/users/{uderId}' with specified id of the user
     * @param id of the user to delete
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "userId") Long id) {
        userService.deleteUser(id);
    }
}