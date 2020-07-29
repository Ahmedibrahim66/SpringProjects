package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
	
	Address findById(long Id);

}
