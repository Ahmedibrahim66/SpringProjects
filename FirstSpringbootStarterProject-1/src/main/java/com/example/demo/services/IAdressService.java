package com.example.demo.services;

import java.util.List;
import com.example.demo.models.Address;

public interface IAdressService {
	
	public List<Address> getAllAddresses();
	public Address getAddress(long id);
	public boolean AddAddress(Address address);
	public boolean UpdateAddress(long id , Address address);
	public boolean DeleteAddress(long id);
	public boolean AddAddressToDepartment(long id, Address address);

}
