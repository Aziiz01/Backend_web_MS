package com.example.gestionpayement.Services;
import com.example.gestionpayement.Entities.Transaction;

import java.util.List;
import java.util.Optional;
public interface ITransaction {
    // Créer une nouvelle transaction
    Transaction createTransaction(Transaction transaction);

    // Récupérer toutes les transactions
    List<Transaction> getAllTransactions();

    // Récupérer une transaction par son ID
    Optional<Transaction> getTransactionById(Long id);

    // Mettre à jour une transaction
    Transaction updateTransaction(Long id, Transaction transactionDetails);

    // Supprimer une transaction
    void deleteTransaction(Long id);
}
