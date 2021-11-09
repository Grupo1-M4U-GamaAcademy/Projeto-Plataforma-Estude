package com.estudegrupo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_address")
	private Integer idAddres;
	
	@Column(name = "street", nullable = false, length = 50)
	private String street;
	
	@Column(name = "city", nullable = false, length = 35)
	private String city;
	
	@Column(name = "state", nullable = false, length = 15)
	private String state;
	
	@Column(name = "zip_code", length = 8)
	private Integer zipCode;
	
	@Column(name = "country", nullable = false, length = 15)
	private String country;
	
	
	
}
