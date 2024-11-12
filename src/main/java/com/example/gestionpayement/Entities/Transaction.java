package com.example.gestionpayement.Entities;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String status;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private Boolean paiementFacilite; // Indique si c'est un paiement facilité
    private Integer nombreMensualites; // Nombre de mensualités
    private Double montantMensualite; // Montant de chaque mensualité

    public Transaction() {}

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getPaiementFacilite() {
        return paiementFacilite;
    }

    public void setPaiementFacilite(Boolean paiementFacilite) {
        this.paiementFacilite = paiementFacilite;
    }

    public Integer getNombreMensualites() {
        return nombreMensualites;
    }

    public void setNombreMensualites(Integer nombreMensualites) {
        this.nombreMensualites = nombreMensualites;
    }

    public Double getMontantMensualite() {
        return montantMensualite;
    }

    public void setMontantMensualite(Double montantMensualite) {
        this.montantMensualite = montantMensualite;
    }
    }

