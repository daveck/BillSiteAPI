package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.Bill;
import com.selman.billrec.repository.BillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    BillRepository billRepository;

    @GetMapping("/bills")
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
    
    @PostMapping("/bills")
    public Bill createBill(@Valid @RequestBody Bill bill) {
        return billRepository.save(bill);
    }
    
    @GetMapping("/groups/{groupFk}/bills/status/{billStatusTypeCd}")
    public List<Bill> getBillsByBillStatusTyepCd(@PathVariable (value = "groupFk") Long groupFk, 
    		@PathVariable (value="billStatusTypeCd") String billStatusTypeCd) {
        return billRepository.findByGroupFkAndBillStatusTypeCd(groupFk, billStatusTypeCd);
    }

    @GetMapping("/groups/{groupFk}/bills")
    public List<Bill> getBillsOrderByBillStatusTyepCd(@PathVariable (value = "groupFk") Long groupFk) {
        return billRepository.findByGroupFkOrderByBillStatusTypeCdAsc(groupFk);
    }
    
    @GetMapping("/bills/status/{billStatusTypeCd}")
    public List<Bill> getBillByStatusTypeCd(@PathVariable(value = "billStatusTypeCd") String billStatusTypeCd) {
        return billRepository.findByBillStatusTypeCdOrderByBillDateAsc(billStatusTypeCd);
    }

    @GetMapping("/bills/invoice/{invoiceNumber}")
    public Bill getBillByInvoiceNumber(@PathVariable(value = "invoiceNumber") String invoiceNumber) {
        return billRepository.findByInvoiceNumber(invoiceNumber);
    }


    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable(value = "id") Long billPk) {
        return billRepository.findById(billPk)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "billPk", billPk));
    }

    @PutMapping("/bills/{id}")
    public Bill updateBill(@PathVariable(value = "id") Long billPk,
                                            @Valid @RequestBody Bill billDetails) {

        Bill bill = billRepository.findById(billPk)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "billPk", billPk));

        bill.setBillStatusTypeCd(billDetails.getBillStatusTypeCd());
        bill.setBillingModeTypeCd(billDetails.getBillingModeTypeCd());

        Bill updatedBill = billRepository.save(bill);
        return updatedBill;
    }

    @DeleteMapping("/bills/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable(value = "id") Long billPk) {
        Bill bill = billRepository.findById(billPk)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "billPk", billPk));

        billRepository.delete(bill);

        return ResponseEntity.ok().build();
    }

    /*
    @GetMapping("/billRecords/{id}")
    public Bill getBillById(@PathVariable(value = "id") Long billPk) {
        return billRepository.findById(billPk)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "billPk", billPk));
    }
    */
}