package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.data.AddressRepo;
import com.example.demo.data.DepartmentRepo;
import com.example.demo.models.Address;
import com.example.demo.models.Department;

@Service
public class AddressServiceImp implements IAdressService {

	@Autowired
	AddressRepo repository;
	
	@Autowired
	DepartmentRepo depRepository;
	

	@Override
	public List<Address> getAllAddresses(int page, int size) {
		
		List<Address> addressList = new ArrayList<>();
		repository.findAll(PageRequest.of(page, size)).forEach(addressList::add);
		return addressList;
		
//		List<Address> addressList = new ArrayList<>();
//		repository.findAll().forEach(addressList::add);
//		return addressList;
		
		
	}

	@Override
	public Address getAddress(long id) {
		Address address = repository.findById(id);
		if (address == null)
			throw new EntityNotFoundException("No address with Id = " + id + "  is found");
		else
			return address;
	}

	@Override
	public boolean AddAddress(Address address) {
		try {
			repository.save(address);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean UpdateAddress(long id, Address address) {
		Address addressFromRepo = repository.findById(id);
		if (addressFromRepo == null)
			throw new EntityNotFoundException("No address with Id = " + id + "  is found");
		else {
			try {
				BeanUtils.copyProperties(address, addressFromRepo);
				repository.save(addressFromRepo);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}
	}

	@Override
	public boolean DeleteAddress(long id) {

		Address address = repository.findById(id);
		if (address == null)
			throw new EntityNotFoundException("No address with Id = " + id + "  is found");
		else {
			repository.deleteById(id);
			return true;
		}
	}

	@Override
	public boolean AddAddressToDepartment(long id, Address address) {
		Department department = depRepository.findById(id);
		if(department == null)
			throw new EntityNotFoundException("No department with Id = " + id + "  is found");
		else {
			address.setDepartment(department);
			repository.save(address);
			department.setAddress(address);
			depRepository.save(department);
			return true;	
		}
	}

}
