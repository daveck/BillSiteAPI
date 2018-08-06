package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.SubGroup;
import com.selman.billrec.repository.SubGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubGroupController {

    @Autowired
    SubGroupRepository subGroupRepository;

    @GetMapping("/subGroups")
    public List<SubGroup> getAllSubGroups() {
        return subGroupRepository.findAll();
    }
    
    @PostMapping("/subGroups")
    public SubGroup createSubGroup(@Valid @RequestBody SubGroup subGroup) {
        return subGroupRepository.save(subGroup);
    }

    @GetMapping("/subGroups/{id}")
    public SubGroup getSubGroupById(@PathVariable(value = "id") Long subGroupPk) {
        return subGroupRepository.findById(subGroupPk)
                .orElseThrow(() -> new ResourceNotFoundException("SubGroup", "subGroupPk", subGroupPk));
    }

    @PutMapping("/subGroups/{id}")
    public SubGroup updateSubGroup(@PathVariable(value = "id") Long subGroupPk,
                                            @Valid @RequestBody SubGroup subGroupDetails) {

        SubGroup subGroup = subGroupRepository.findById(subGroupPk)
                .orElseThrow(() -> new ResourceNotFoundException("SubGroup", "subGroupPk", subGroupPk));


        subGroup.setGroupFk(subGroupDetails.getGroupFk());
        subGroup.setSubGroupFk(subGroupDetails.getSubGroupFk());
        subGroup.setName(subGroupDetails.getName());
        subGroup.setDescription(subGroupDetails.getDescription());
        SubGroup updatedSubGroup = subGroupRepository.save(subGroup);
        return updatedSubGroup;
    }

    @DeleteMapping("/subGroups/{id}")
    public ResponseEntity<?> deleteSubGroup(@PathVariable(value = "id") Long subGroupPk) {
        SubGroup subGroup = subGroupRepository.findById(subGroupPk)
                .orElseThrow(() -> new ResourceNotFoundException("SubGroup", "subGroupPk", subGroupPk));

        subGroupRepository.delete(subGroup);

        return ResponseEntity.ok().build();
    }

}