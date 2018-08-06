package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.BillRelease;
import com.selman.billrec.repository.BillReleaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillReleaseController {

    @Autowired
    BillReleaseRepository billReleaseRepository;

    @GetMapping("/billReleases")
    public List<BillRelease> getAllBillReleases() {
        return billReleaseRepository.findAll();
    }
    
    @PostMapping(path = "/billReleases", 
    		 consumes = {MediaType.APPLICATION_JSON_VALUE},
             produces = {MediaType.APPLICATION_JSON_VALUE})
    public BillRelease createBillRelease(@Valid @RequestBody BillRelease billRelease) {
        return billReleaseRepository.save(billRelease);
    }

    @GetMapping("/billReleases/{id}")
    public BillRelease getBillReleaseById(@PathVariable(value = "id") Long billReleasePk) {
        return billReleaseRepository.findById(billReleasePk)
                .orElseThrow(() -> new ResourceNotFoundException("BillRelease", "billReleasePk", billReleasePk));
    }

    @PutMapping("/billReleases/{id}")
    public BillRelease updateBillRelease(@PathVariable(value = "id") Long billReleasePk,
                                            @Valid @RequestBody BillRelease billReleaseDetails) {

        BillRelease billRelease = billReleaseRepository.findById(billReleasePk)
                .orElseThrow(() -> new ResourceNotFoundException("BillRelease", "billReleasePk", billReleasePk));

        billRelease.setBillFk(billReleaseDetails.getBillFk());
        billRelease.setReleaseUser(billReleaseDetails.getReleaseUser());
        BillRelease updatedBillRelease = billReleaseRepository.save(billRelease);
        return updatedBillRelease;
    }

    @DeleteMapping("/billReleases/{id}")
    public ResponseEntity<?> deleteBillRelease(@PathVariable(value = "id") Long billReleasePk) {
        BillRelease billRelease = billReleaseRepository.findById(billReleasePk)
                .orElseThrow(() -> new ResourceNotFoundException("BillRelease", "billReleasePk", billReleasePk));
        

        billReleaseRepository.delete(billRelease);

        return ResponseEntity.ok().build();
    }

}