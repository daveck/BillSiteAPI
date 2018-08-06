package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.Payment;
import com.selman.billrec.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    @PostMapping("/payments")
    public Payment createPayment(@Valid @RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @GetMapping("/payments/{id}")
    public Payment getPaymentById(@PathVariable(value = "id") Long paymentPk) {
        return paymentRepository.findById(paymentPk)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "paymentPk", paymentPk));
    }

    @GetMapping("bills/{billFk}/payments")
    public List<Payment> getPaymentByBillFk(@PathVariable(value = "id") Long billFk) {
        return paymentRepository.findByBillFkOrderByPaymentDateDesc(billFk);
    }

    @PutMapping("/payments/{id}")
    public Payment updatePayment(@PathVariable(value = "id") Long paymentPk,
                                            @Valid @RequestBody Payment paymentDetails) {

        Payment payment = paymentRepository.findById(paymentPk)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "paymentPk", paymentPk));

        payment.setModUser(paymentDetails.getModUser());
        payment.setPaymentStatusCd(paymentDetails.getPaymentStatusCd());
        Payment updatedPayment = paymentRepository.save(payment);
        return updatedPayment;
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable(value = "id") Long paymentPk) {
        Payment payment = paymentRepository.findById(paymentPk)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "paymentPk", paymentPk));
        

        paymentRepository.delete(payment);

        return ResponseEntity.ok().build();
    }

}