package com.example.gestionpayement.Services;

import com.example.gestionpayement.Entities.Transaction;
import com.example.gestionpayement.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceIMP {

    @Autowired
    private TransactionRepository transactionRepository;

    // Créer une nouvelle transaction
    public Transaction createTransaction(Transaction transaction) {
        // Si c'est un paiement facilité, calculer les mensualités
        if (transaction.getPaiementFacilite() != null && transaction.getPaiementFacilite()) {
            double montantMensualite = transaction.getAmount() / transaction.getNombreMensualites();
            transaction.setMontantMensualite(montantMensualite);
        }
        return transactionRepository.save(transaction);
    }

    // Récupérer toutes les transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Récupérer une transaction par son ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Mettre à jour une transaction
    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        // Vérifie si la transaction existe
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));

        // Si c'est un paiement facilité, calculer les mensualités
        if (transactionDetails.getPaiementFacilite() != null && transactionDetails.getPaiementFacilite()) {
            double montantMensualite = transactionDetails.getAmount() / transactionDetails.getNombreMensualites();
            transactionDetails.setMontantMensualite(montantMensualite);
        }

        transaction.setAmount(transactionDetails.getAmount());
        transaction.setPaymentMethod(transactionDetails.getPaymentMethod());
        transaction.setStatus(transactionDetails.getStatus());
        transaction.setPaiementFacilite(transactionDetails.getPaiementFacilite());
        transaction.setNombreMensualites(transactionDetails.getNombreMensualites());
        transaction.setMontantMensualite(transactionDetails.getMontantMensualite());

        return transactionRepository.save(transaction);
    }

    // Supprimer une transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
