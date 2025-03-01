package com.bridgelabz.springaddressbook.controller;

import com.bridgelabz.springaddressbook.dto.AddressBookDTO;
import com.bridgelabz.springaddressbook.dto.ResponseDTO;
import com.bridgelabz.springaddressbook.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllAddresses() {
        AddressBook address = new AddressBook(1, "John Doe", "1234567890", "New York");
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", address);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable int id) {
        AddressBook address = new AddressBook(id, "John Doe", "1234567890", "New York");
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", address);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook address = new AddressBook(1, addressBookDTO.getName(), addressBookDTO.getPhoneNumber(), addressBookDTO.getCity());
        ResponseDTO respDTO = new ResponseDTO("Created Address Successfully", address);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddress(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook address = new AddressBook(1, addressBookDTO.getName(), addressBookDTO.getPhoneNumber(), addressBookDTO.getCity());
        ResponseDTO respDTO = new ResponseDTO("Updated Address Successfully", address);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable int id) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted ID: " + id);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}