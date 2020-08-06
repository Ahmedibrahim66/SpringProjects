package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.Address;

public interface AddressRepo extends PagingAndSortingRepository<Address, Long> {
	
	Address findById(long Id);

}
