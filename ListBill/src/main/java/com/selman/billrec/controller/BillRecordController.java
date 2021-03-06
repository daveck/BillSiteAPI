package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.BillRecord;
import com.selman.billrec.repository.BillRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class BillRecordController {

    @Autowired
    BillRecordRepository billRecordRepository;

    @PostMapping("/billRecords")
    public BillRecord createBillRecords(@Valid @RequestBody BillRecord billRecord) {
        return billRecordRepository.save(billRecord);
    }
    
    // REMOVE
    @GetMapping("/billRecords")
    public List<BillRecord> getAllBillRecords() {
        return billRecordRepository.findAll();
    }
    
    @GetMapping("/bills/{billFk}/billRecords")
    public List<BillRecord> getBillRecordsByBillFk(@PathVariable (value = "billFk") Long billFk) {
        return billRecordRepository.findByBillFkOrderByEmployeeIdAsc(billFk);
    }

    @GetMapping("/billRecords/{id}")
    public BillRecord getBillRecordsById(@PathVariable(value = "id") Long billRecordPk) {
        return billRecordRepository.findById(billRecordPk)
                .orElseThrow(() -> new ResourceNotFoundException("BillRecord", "billRecordPk", billRecordPk));
    }

    @PutMapping("/billRecords/{id}")
    public BillRecord updateBillRecord(@PathVariable(value = "id") Long billRecordPk,
                                            @Valid @RequestBody BillRecord billRecordDetails) {

        BillRecord billRecord = billRecordRepository.findById(billRecordPk)
                .orElseThrow(() -> new ResourceNotFoundException("BillRecord", "billRecordPk", billRecordPk));
        
        billRecord.setModUser(billRecordDetails.getModUser());
        billRecord.setEmployeeName(billRecordDetails.getEmployeeName());
        billRecord.setEmployeeId(billRecordDetails.getEmployeeId());
        billRecord.setUpdateStatusTypeCd(billRecordDetails.getUpdateStatusTypeCd());

        BillRecord updatedBillRecords = billRecordRepository.save(billRecord);
        return updatedBillRecords;
    }

    @DeleteMapping("/billRecords/{id}")
    public ResponseEntity<?> deleteBillRecord(@PathVariable(value = "id") Long billRecordPk) {
        BillRecord billRecord = billRecordRepository.findById(billRecordPk)
                .orElseThrow(() -> new ResourceNotFoundException("BillRecord", "billRecordPk", billRecordPk));

        billRecordRepository.delete(billRecord);

        return ResponseEntity.ok().build();
    }

}