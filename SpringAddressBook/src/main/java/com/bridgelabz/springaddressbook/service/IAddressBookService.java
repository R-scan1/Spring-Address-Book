package com.bridgelabz.springaddressbook.service;

import com.bridgelabz.springaddressbook.dto.AddressBookDTO;
import com.bridgelabz.springaddressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    List<AddressBook> getAllAddresses();

    AddressBook getAddressById(int id);

    AddressBook createAddress(AddressBookDTO addressBookDTO);

    AddressBook updateAddress(AddressBookDTO addressBookDTO);

    void deleteAddress(int id);
}
