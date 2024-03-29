package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.UserModel;
import com.RISE.sylla.repository.UserRepository;
import java.util.List;
import java.util.Optional;

/**
 * Cette classe crée toutes les méthodes lié au user qui seront appelé par notre controlleur user afin de géré les requêtes
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Cette méthode crée un nouveau user
     * @param user voir les parametre de la classe userModel
     * @return un objet user
     */
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    /**
     * Cette methode retourne tous les users
     * @return une liste d'objet user
     */
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Cette méthode retourne le user par l'id
     * @param userId l'identifiant unique du user
     * @return l'objet user identifiable par l'id
     */
    public Optional<UserModel> getUserById(Long userId){return userRepository.findById(userId);}

    /**
     * Cette méthode efface le user par son id
     * @param userId l'identfiant de l'user
     */
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    /**
     * Cette méthode met à jour le user identifié avec l'id avec les params passées
     * @param userId l'identifiant du user
     * @param userDetails les parametre de l'objet user : voir userModel pour plus de détails
     * @return un objet user
     */
    public UserModel updateUser(Long userId, UserModel userDetails) {
        UserModel user = userRepository.findById(userId).get();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmailId(userDetails.getEmailId());

        return userRepository.save(user);
    }
}
