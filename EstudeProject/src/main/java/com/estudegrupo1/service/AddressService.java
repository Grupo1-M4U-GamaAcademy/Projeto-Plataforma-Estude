package com.estudegrupo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudegrupo1.model.Address;
import com.estudegrupo1.repository.AddressRepository;

@Service
public class AddressService {
	

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress (Address address) {
        return addressRepository.save(address);
    }

    public List<Address> createAddressList(List<Address> list) {
        return addressRepository.saveAll(list);
    }

    public List<Address> getAddressList() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer idAddress) {
        return addressRepository.findById(idAddress).orElse(null);
    }

    public Address updateAddressById(Address address) {
        Optional<Address> addressFound = addressRepository.findById(address.getIdAddres());

        if (addressFound.isPresent()) {
            Address addressUpdate = addressFound.get();
            addressUpdate.setCity(address.getCity());
            addressUpdate.setCountry(address.getCountry());
            addressUpdate.setState(address.getState());
            addressUpdate.setStreet(address.getStreet());
            addressUpdate.setZipCode(address.getZipCode());

            return addressRepository.save(address);
        } else {
            return null;
        }
    }

    public String deleteAddressById(Integer idAddress) {
        addressRepository.deleteById(idAddress);
        return "Address "+ idAddress +" deleted";
    }
}

