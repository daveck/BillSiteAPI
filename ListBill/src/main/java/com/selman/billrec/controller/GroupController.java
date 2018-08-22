package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.Bill;
import com.selman.billrec.model.BillRecord;
import com.selman.billrec.model.Contract;
import com.selman.billrec.model.Group;
import com.selman.billrec.repository.BillRepository;
import com.selman.billrec.repository.GroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    // REMOVE
    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
    
    @GetMapping("/groups/number/{groupNumber}")
    public Group getGroupByGroupNumber(@PathVariable (value = "groupNumber") String groupNumber) {
        return groupRepository.findByGroupNumber(groupNumber);
    }
    
    @PostMapping("/groups")
    public Group createGroup(@Valid @RequestBody Group group) {
        return groupRepository.save(group);
    }

    @PreAuthorize("hasAuthority('read:groups)")
    @GetMapping("/groups/{id}")
    public Group getGroupById(@PathVariable(value = "id") Long groupPk) {
        return groupRepository.findById(groupPk)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "groupPk", groupPk));
    }

    @PutMapping("/groups/{id}")
    public Group updateGroup(@PathVariable(value = "id") Long groupPk,
                                            @Valid @RequestBody Group groupDetails) {

        Group group = groupRepository.findById(groupPk)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "groupPk", groupPk));

        group.setModUser(groupDetails.getModUser());
        group.setGroupName(groupDetails.getGroupName());
        group.setRep(groupDetails.getRep());
        group.setTerminationDate(groupDetails.getTerminationDate());

        Group updatedGroup = groupRepository.save(group);
        return updatedGroup;
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value = "id") Long groupPk) {
        Group group = groupRepository.findById(groupPk)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "groupPk", groupPk));

        groupRepository.delete(group);

        return ResponseEntity.ok().build();
    }

    /*
    @GetMapping("/groupRecords/{id}")
    public Group getGroupById(@PathVariable(value = "id") Long groupPk) {
        return groupRepository.findById(groupPk)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "groupPk", groupPk));
    }
    */
}