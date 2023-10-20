package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.userModel;
import com.RISE.sylla.service.userService;

/**
 * This Class redirects '/user' to the appropriate methods defined in the userService
 */

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    userService userService;

    /**
     * POST method '/users' creating user with params
     * body need to look like : {
     *      "firstname": "test",
     *      "lastname": "test",
     *      "email": "test",
     *      "role": "test",
     *      "matricule" : 12345,
     *      "trigram" : "test"
     * }
     * @param user param user object
     * @return new posted user
     */
    @RequestMapping(value="", method= RequestMethod.POST)
    public userModel createUser(@RequestBody userModel user) {
        return userService.createUser(user);
    }

    /**
     * GET method '/users' returning users
     * @return list of all users
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<userModel> readUsers() {
        return userService.getUsers();
    }

    /**
     * GET method '/users/{userId}' returning user corresponding to id as param
     * @param id of the user to be returned
     * @return If it exists, the user
     */
    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public Optional<userModel> readUserById(@PathVariable(value = "userId") Long id) {
        return userService.getUserById(id);
    }

    /**
     * PUT method '/users/{userId}' updating the user with the specified id
     * body need to look like : {
     *          "userId": 1,
     *          "firstName": "test",
     *          "lastName": "test",
     *          "emailId":"test",
     *          "role": "test",
     *          "matricule" : 1,
     *          "trigram" : "test"
     *    }
     *
     * @param id of the user to modify
     * @param userDetails details to modify with variables
     * @return the user modified
     */
    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    public userModel updateUsers(@PathVariable(value = "userId") Long id, @RequestBody userModel userDetails) {
        return userService.updateUser(id, userDetails);
    }

    /**
     * DELETE method '/users/{userId}' with specified id of the user
     * @param id of the user to delete
     */
    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "userId") Long id) {
        userService.deleteUser(id);
    }
}