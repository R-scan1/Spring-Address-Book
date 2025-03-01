package com.bridgelabz.springaddressbook.service;

import com.bridgelabz.springaddressbook.dto.AddressBookDTO;
import com.bridgelabz.springaddressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private List<AddressBook> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBook> getAllAddresses() {
        return addressBookList;
    }

    @Override
    public AddressBook getAddressById(int id) {
        return addressBookList.stream()
                .filter(address -> address.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBook createAddress(AddressBookDTO addressBookDTO) {
        AddressBook newAddress = new AddressBook(addressBookList.size() + 1, addressBookDTO.getName(), 
                                                 addressBookDTO.getPhoneNumber(), addressBookDTO.getCity());
        addressBookList.add(newAddress);
        return newAddress;
    }

    @Override
    public AddressBook updateAddress(AddressBookDTO addressBookDTO) {
        AddressBook existingAddress = getAddressById(addressBookDTO.getId());
        if (existingAddress != null) {
            existingAddress.setName(addressBookDTO.getName());
            existingAddress.setPhoneNumber(addressBookDTO.getPhoneNumber());
            existingAddress.setCity(addressBookDTO.getCity());
            return existingAddress;
        }
        return null;
    }

    @Override
    public void deleteAddress(int id) {
        addressBookList.removeIf(address -> address.getId() == id);
    }
}
