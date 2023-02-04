package com.CBFSD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CBFSD.entity.CabType;
import com.CBFSD.repository.CabTypeRepository;

@Service
public class CabTypeService {

	@Autowired
	CabTypeRepository cabTypeRepository;
	
	
	public String storeCabType(CabType cabType) {
		cabTypeRepository.save(cabType);
		return "Cab Type details stored successfully";
	}
	
	public List<CabType> getAllCabTypes() {
		return cabTypeRepository.findAll();
	}
	

	
	public CabType findCabType(int cabTypeId) {
		Optional<CabType> result = cabTypeRepository.findById(cabTypeId);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
}
