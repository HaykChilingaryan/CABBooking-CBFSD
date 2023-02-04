package com.CBFSD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CBFSD.entity.CabType;

@Repository
public interface CabTypeRepository extends JpaRepository<CabType, Integer> {

}
