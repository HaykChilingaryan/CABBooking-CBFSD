package com.CBFSD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CBFSD.entity.CabType;
import com.CBFSD.service.CabTypeService;

@RestController
@RequestMapping("cabtype")
@CrossOrigin(origins = "http://localhost:4200")
public class CabTypeController {

	@Autowired
	CabTypeService cabTypeService;
	
	@PostMapping(value = "storeCabType",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeCabType(@RequestBody CabType cabType) {
		return cabTypeService.storeCabType(cabType);
	}
	
	@GetMapping(value = "findAllCabType",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CabType> findAllCategories() {
		return cabTypeService.getAllCabTypes();
	}
	
	@GetMapping(value = "findCabTypeById/{cabTypeId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public CabType findAllById(@PathVariable("cabTypeId") int cabTypeId) {
		return cabTypeService.findCabType(cabTypeId);
	}
}
