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
 * Cette Classe controlleur redirige les routes après '/user' vers les méthodes définit dans le service controller
 * Afin de répondre avec les données correspondantes au differentes requetes
 */

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userService userService;

    /**
     * Cette méthode gère la requete POST '/user/users' en créant un utilisateur avec les params
     * @param user prends les params d'un objet User : Voir documentation de la classe userModel
     * @return un nouveau objet user
     */
    @RequestMapping(value="/users", method= RequestMethod.POST)
    public userModel createUser(@RequestBody userModel user) {
        return userService.createUser(user);
    }

    /**
     * Cette méthode gère la requete GET '/user/users' en retournant tous les users
     * @return une liste d'objet user
     */
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<userModel> readUsers() {
        return userService.getUsers();
    }

    /**
     * Cette méthode gère la requete GET '/users/{userId}' en retournant l'user correspondant a l'id en param
     * @param id l'identifiant de l'user dans la base de données
     * @return Si l'id existe un objet user
     */
    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public Optional<userModel> readUserById(@PathVariable(value = "userId") Long id) {
        return userService.getUserById(id);
    }

    /**
     * Cette méthode gère la requete PUT de '/user/users/{userId}' en updatant le user avec les params
     * @param id l'identifiant du user à modifier
     * @param userDetails les données à modifier dans le user ciblé
     * @return un objet user
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
    public userModel readUsers(@PathVariable(value = "userId") Long id, @RequestBody userModel userDetails) {
        return userService.updateUser(id, userDetails);
    }

    /**
     * Cette méthode gere la requete DELETE de 'user/users/{uderId}' en prenant l'id du user a effacé dans la bdd
     * @param id l'identifiant du user
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "userId") Long id) {
        userService.deleteUser(id);
    }
}