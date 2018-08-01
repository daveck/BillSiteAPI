package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.Contract;
import com.selman.billrec.repository.ContractRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ContractController {

    @Autowired
    ContractRepository contractRepository;

    @PostMapping("/contracts")
    public Contract createContracts(@Valid @RequestBody Contract contract) {
        return contractRepository.save(contract);
    }
    
    //REMOVE
    @GetMapping("/contracts")
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }
    
    @GetMapping("/billRecords/{billRecordFk}/contracts")
    public List<Contract> getContractsByBillRecordFk(@PathVariable (value = "billRecordFk") Long billRecordFk) {
        return contractRepository.findByBillRecordFkOrderByContractNumberAsc(billRecordFk);
    }


    @GetMapping("/contracts/{id}")
    public Contract getContractsById(@PathVariable(value = "id") Long contractPk) {
        return contractRepository.findById(contractPk)
                .orElseThrow(() -> new ResourceNotFoundException("Contract", "contractPk", contractPk));
    }

    @PutMapping("/contracts/{id}")
    public Contract updateContract(@PathVariable(value = "id") Long contractPk,
                                            @Valid @RequestBody Contract contractDetails) {

        Contract contract = contractRepository.findById(contractPk)
                .orElseThrow(() -> new ResourceNotFoundException("Contract", "contractPk", contractPk));

        contract.setBillRecordFk(contractDetails.getBillRecordFk());
        contract.setProductTypeCd(contractDetails.getProductTypeCd());
        contract.setInsuredFullName(contractDetails.getInsuredFullName());
        contract.setInsuredFirstName(contractDetails.getInsuredFirstName());
        contract.setInsuredLastName(contractDetails.getInsuredLastName());
        contract.setContractNumber(contractDetails.getContractNumber());
        contract.setCoverage(contractDetails.getCoverage());
        contract.setSingleDeductionAmount(contractDetails.getSingleDeductionAmount());
        contract.setTotalDeductionAmount(contractDetails.getTotalDeductionAmount());
        contract.setPreviousBillAmount(contractDetails.getPreviousBillAmount());
        contract.setCreditAmount(contractDetails.getCreditAmount());
        contract.setUpdateStatusCd(contractDetails.getUpdateStatusCd());
        contract.setNumber_of_deductions(contractDetails.getNumber_of_deductions());
        contract.setSortCode(contractDetails.getSortCode());
        contract.setNotes(contractDetails.getNotes());
        contract.setSourceSystemCd(contractDetails.getSourceSystemCd());

        Contract updatedContracts = contractRepository.save(contract);
        return updatedContracts;
    }

    @DeleteMapping("/contracts/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable(value = "id") Long contractPk) {
        Contract contract = contractRepository.findById(contractPk)
                .orElseThrow(() -> new ResourceNotFoundException("Contract", "contractPk", contractPk));

        contractRepository.delete(contract);

        return ResponseEntity.ok().build();
    }

}