package com.RISE.sylla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cette classe est le "template" de user et contient les get/set afin de modifier ses parametres
 */

@Entity
@Table(name = "users")
public class userModel {
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getRole() {
        return role;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getTrigram() {
        return trigram;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setTrigram(String trigram) {
        this.trigram = trigram;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userId;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="email")
    private String emailId;

    @Column(name="role")
    private String role;

    @Column(name="matricule")
    private int matricule;

    @Column(name="trigram")
    private String trigram;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
