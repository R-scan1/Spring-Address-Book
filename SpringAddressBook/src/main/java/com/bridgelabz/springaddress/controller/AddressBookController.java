package com.bridgelabz.springaddress.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("GET: Returning all contacts.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("GET: Returning contact with ID " + id);
    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestParam int id, @RequestParam String name) {
        return ResponseEntity.ok("POST: Added contact " + name + " with ID " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id, @RequestParam String name) {
        return ResponseEntity.ok("PUT: Updated contact ID " + id + " to " + name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("DELETE: Removed contact with ID " + id);
    }
}