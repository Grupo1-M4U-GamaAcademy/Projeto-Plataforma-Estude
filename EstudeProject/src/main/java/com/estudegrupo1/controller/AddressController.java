package com.estudegrupo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudegrupo1.model.Address;
import com.estudegrupo1.service.AddressService;


@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddress() {
		return ResponseEntity.ok(addressService.getAddressList());
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Integer idAddress) {
		return ResponseEntity.ok().body(this.addressService.getAddressById(idAddress));
	}

	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		return ResponseEntity.ok(this.addressService.createAddress(address));
	}

	@PutMapping("/updateAddress/")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		return ResponseEntity.ok().body(this.addressService.updateAddressById(address));
	}

	@DeleteMapping("/deleteAddress/{id}")
	public HttpStatus deleteAddress(@PathVariable Integer idAddress) {
		this.addressService.deleteAddressById(idAddress);
		return HttpStatus.OK;
	}
	
}
