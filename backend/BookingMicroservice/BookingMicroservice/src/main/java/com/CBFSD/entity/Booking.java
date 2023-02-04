package com.CBFSD.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Booking {
	
	@Id
	private int bookingId;
	private double bookingDistance;
	private double bookingFare;
	private Date bookingDate;
	private Time bookingTime;
	private int cabTypeId;

}
