package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.Address;
import com.selman.billrec.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    // for testing
    @GetMapping("/addresses")
    public List<Address> getAllAddresss() {
        return addressRepository.findAll();
    }
    
    @PostMapping("/addresses")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("/addresses/{id}")
    public Address getAddressById(@PathVariable(value = "id") Long addressPk) {
        return addressRepository.findById(addressPk)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressPk", addressPk));
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@PathVariable(value = "id") Long addressPk,
                                            @Valid @RequestBody Address addressDetails) {

        Address address = addressRepository.findById(addressPk)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressPk", addressPk));

        address.setAddressLine_1(addressDetails.getAddressLine_1());
        address.setAddressLine_2(addressDetails.getAddressLine_2());
        address.setCity(addressDetails.getCity());
        address.setStateCd(addressDetails.getStateCd());
        address.setZipCode(addressDetails.getZipCode());
        address.setCountryCd(addressDetails.getCountryCd());
        address.setEffectiveDate(addressDetails.getEffectiveDate());
        address.setTerminationDate(addressDetails.getTerminationDate());
        

        Address updatedAddress = addressRepository.save(address);
        return updatedAddress;
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long addressPk) {
        Address address = addressRepository.findById(addressPk)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressPk", addressPk));

        addressRepository.delete(address);

        return ResponseEntity.ok().build();
    }

}