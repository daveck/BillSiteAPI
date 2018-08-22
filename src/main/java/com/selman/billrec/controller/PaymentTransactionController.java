package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.PaymentTransaction;
import com.selman.billrec.repository.PaymentTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentTransactionController {

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;

    @GetMapping("/paymentTransactions")
    public List<PaymentTransaction> getAllPaymentTransactions() {
        return paymentTransactionRepository.findAll();
    }
    
    @GetMapping("/groups/{groupFk}/paymentTransactions")
    public List<PaymentTransaction> getPaymentTransactionsByGroupFk(@PathVariable (value = "groupFk") Long groupFk) {
        return paymentTransactionRepository.findByGroupFkOrderByStatusAsc(groupFk);
    }

    @GetMapping("/groups/{groupFk}/paymentTransactions/status/{status}")
    public List<PaymentTransaction> getPaymentTransactionsByGroupFkAndStatus(
    		@PathVariable (value = "groupFk") Long groupFk,
    		@PathVariable (value = "status") String status ) {
        return paymentTransactionRepository.findByGroupFkAndStatus(groupFk, status);
    }
    
    @PostMapping("/paymentTransactions")
    public PaymentTransaction createPaymentTransaction(@Valid @RequestBody PaymentTransaction paymentTransaction) {
        return paymentTransactionRepository.save(paymentTransaction);
    }

    @GetMapping("/paymentTransactions/{id}")
    public PaymentTransaction getPaymentTransactionById(@PathVariable(value = "id") Long paymentTransactionPk) {
        return paymentTransactionRepository.findById(paymentTransactionPk)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentTransaction", "paymentTransactionPk", paymentTransactionPk));
    }
    
    @PutMapping("/paymentTransactions/{id}")
    public PaymentTransaction updatePaymentTransaction(@PathVariable(value = "id") Long paymentTransactionPk,
                                            @Valid @RequestBody PaymentTransaction paymentTransactionDetails) {

        PaymentTransaction paymentTransaction = paymentTransactionRepository.findById(paymentTransactionPk)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentTransaction", "paymentTransactionPk", paymentTransactionPk));

        paymentTransaction.setStatus(paymentTransactionDetails.getStatus());
        paymentTransaction.setModUser(paymentTransactionDetails.getModUser());
        paymentTransaction.setAddUser(paymentTransactionDetails.getAddUser());

        PaymentTransaction updatedPaymentTransaction = paymentTransactionRepository.save(paymentTransaction);
        return updatedPaymentTransaction;
    }

    @DeleteMapping("/paymentTransactions/{id}")
    public ResponseEntity<?> deletePaymentTransaction(@PathVariable(value = "id") Long paymentTransactionPk) {
        PaymentTransaction paymentTransaction = paymentTransactionRepository.findById(paymentTransactionPk)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentTransaction", "paymentTransactionPk", paymentTransactionPk));

        paymentTransactionRepository.delete(paymentTransaction);

        return ResponseEntity.ok().build();
    }

}