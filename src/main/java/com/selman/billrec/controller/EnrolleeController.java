package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.BillRecord;
import com.selman.billrec.model.Enrollee;
import com.selman.billrec.repository.EnrolleeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EnrolleeController {

    @Autowired
    EnrolleeRepository enrolleeRepository;

    @GetMapping("/enrollees")
    public List<Enrollee> getAllEnrollees() {
        return enrolleeRepository.findAll();
    }
    
    @PostMapping("/enrollees")
    public Enrollee createEnrollee(@Valid @RequestBody Enrollee enrollee) {
        return enrolleeRepository.save(enrollee);
    }

    @GetMapping("/enrollees/{id}")
    public Enrollee getEnrolleeById(@PathVariable(value = "id") Long enrolleePk) {
        return enrolleeRepository.findById(enrolleePk)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollee", "enrolleePk", enrolleePk));
    }
    
    @GetMapping("/groups/{groupFk}/enrollees")
    public List<Enrollee> getEnrolleesByGroupFk(@PathVariable (value = "groupFk") Long groupFk) {
        return enrolleeRepository.findByGroupFk(groupFk);
    }

    @PutMapping("/enrollees/{id}")
    public Enrollee updateEnrollee(@PathVariable(value = "id") Long enrolleePk,
                                            @Valid @RequestBody Enrollee enrolleeDetails) {

        Enrollee enrollee = enrolleeRepository.findById(enrolleePk)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollee", "enrolleePk", enrolleePk));

        enrollee.setEmployeeName(enrolleeDetails.getEmployeeName());
        enrollee.setEmployeeId(enrolleeDetails.getEmployeeId());
        enrollee.setEmployeeSsn(enrolleeDetails.getEmployeeSsn());
        enrollee.setInsuredName(enrolleeDetails.getInsuredName());
        enrollee.setGroupFk(enrolleeDetails.getGroupFk());
        enrollee.setCoverageTypeCd(enrolleeDetails.getCoverageTypeCd());
        enrollee.setCoverageAmount(enrolleeDetails.getCoverageAmount());
        enrollee.setEnrolleeStatusTypeCd(enrollee.getEnrolleeStatusTypeCd());


        Enrollee updatedEnrollee = enrolleeRepository.save(enrollee);
        return updatedEnrollee;
    }

    @DeleteMapping("/enrollees/{id}")
    public ResponseEntity<?> deleteEnrollee(@PathVariable(value = "id") Long enrolleePk) {
        Enrollee enrollee = enrolleeRepository.findById(enrolleePk)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollee", "enrolleePk", enrolleePk));

        enrolleeRepository.delete(enrollee);

        return ResponseEntity.ok().build();
    }

}