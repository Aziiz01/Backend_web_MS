package com.esprit.commentaireService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // Auto-generated primary key

    private String userId; // Represents the ID of the user who made the comment

    private String description; // The content of the comment

    // Default constructor
    public Commentaire() {
    }

    // Parameterized constructor
    public Commentaire(String userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
