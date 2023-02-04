package com.CBFSD.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CabType {

	@Id
	private int cabTypeId;
	private String cabTypeName;
	private double cabTypeFare;
	@OneToMany
	@JoinColumn(name = "cabTypeId",referencedColumnName = "cabTypeId")
	private List<Booking> listOfBookings;
	
}

