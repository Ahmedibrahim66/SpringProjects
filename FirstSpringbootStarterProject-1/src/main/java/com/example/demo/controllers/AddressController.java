package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.models.Address;
import com.example.demo.services.IAdressService;

@RestController
@RequestMapping(value = "/api")
public class AddressController {
	
	@Autowired
	IAdressService addressService;
	
	
	
	@GetMapping(value= "/address" , params = { "page", "size" })
	public List<Address> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse response) {
		return addressService.getAllAddresses(page, size);
	}
	
	
	@GetMapping(value="/address/{id}")
	public Address getAddress(@PathVariable long id) {
		return addressService.getAddress(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value= "/address")
	public Boolean addAddress(@RequestBody Address address) {
		return addressService.AddAddress(address);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/address/{id}")
	public Boolean UpdateAddress(@RequestBody Address address, @PathVariable long id) {
		return addressService.UpdateAddress(id, address);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/address/{id}")
	public Boolean DeleteAddress(@PathVariable long id) {
		return addressService.DeleteAddress(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/departments/{id}/address")
	public Boolean AddInstructorToDepartment(@PathVariable long id, @RequestBody Address address) {
		return addressService.AddAddressToDepartment(id, address);
	}
	
	

	

}
