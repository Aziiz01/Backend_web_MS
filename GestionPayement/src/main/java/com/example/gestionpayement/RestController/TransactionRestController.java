package com.example.gestionpayement.RestController;

import com.example.gestionpayement.Entities.Transaction;
import com.example.gestionpayement.Services.TransactionServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/transactions")
@CrossOrigin("*")
public class TransactionRestController {

    @Autowired
    private TransactionServiceIMP transactionService;

    // Créer une nouvelle transaction
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(201).body(createdTransaction);
    }

    // Récupérer toutes les transactions
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Récupérer une transaction par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return ResponseEntity.ok(transaction);
    }

    // Mettre à jour une transaction
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDetails);
        return ResponseEntity.ok(updatedTransaction);
    }

    // Supprimer une transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
