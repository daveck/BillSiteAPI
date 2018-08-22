package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.Case;
import com.selman.billrec.model.Group;
import com.selman.billrec.repository.CaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CaseController {

    @Autowired
    CaseRepository caseRepository;

    // REMOVE
    @GetMapping("/cases")
    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }
    
    @PostMapping("/cases")
    public Case createCase(@Valid @RequestBody Case c) {
        return caseRepository.save(c);
    }
    
    @GetMapping("/cases/number/{caseNumber}")
    public Case getCaseByCaseNumber(@PathVariable (value = "caseNumber") String caseNumber) {
        return caseRepository.findByCaseNumber(caseNumber);
    }

    @GetMapping("/cases/{id}")
    public Case getCaseById(@PathVariable(value = "id") Long casePk) {
        return caseRepository.findById(casePk)
                .orElseThrow(() -> new ResourceNotFoundException("Case", "casePk", casePk));
    }

    @PutMapping("/cases/{id}")
    public Case updateCase(@PathVariable(value = "id") Long casePk,
                                            @Valid @RequestBody Case caseDetails) {

        Case c = caseRepository.findById(casePk)
                .orElseThrow(() -> new ResourceNotFoundException("Case", "casePk", casePk));

        c.setCaseNumber(caseDetails.getCaseNumber());
        c.setCaseName(caseDetails.getCaseName());
        c.setEffectiveDate(caseDetails.getEffectiveDate());
        c.setTerminationDate(caseDetails.getTerminationDate());

        Case updatedCase = caseRepository.save(c);
        return updatedCase;
    }

    @DeleteMapping("/cases/{id}")
    public ResponseEntity<?> deleteCase(@PathVariable(value = "id") Long casePk) {
        Case c = caseRepository.findById(casePk)
                .orElseThrow(() -> new ResourceNotFoundException("Case", "casePk", casePk));

        caseRepository.delete(c);

        return ResponseEntity.ok().build();
    }

    /*
    @GetMapping("/caseRecords/{id}")
    public Case getCaseById(@PathVariable(value = "id") Long casePk) {
        return caseRepository.findById(casePk)
                .orElseThrow(() -> new ResourceNotFoundException("Case", "casePk", casePk));
    }
    */
}