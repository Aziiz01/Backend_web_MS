package com.example.gestionpayement.Repository;
import com.example.gestionpayement.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  TransactionRepository extends JpaRepository<Transaction, Long> {
}
