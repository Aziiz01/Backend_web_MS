package com.esprit.offreService.dto;

public class CommentaireDTO {
    private String id;
    private String content;
    
    // Default constructor
    public CommentaireDTO() {}

    // Constructor with fields
    public CommentaireDTO(String id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Optionally, add toString(), equals(), and hashCode() methods if needed
}
