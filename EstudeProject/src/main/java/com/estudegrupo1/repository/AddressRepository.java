package com.estudegrupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estudegrupo1.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {



}
