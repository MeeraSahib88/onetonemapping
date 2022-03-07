package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GenericGenerator(name = "uuid-gen",strategy  = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	/* @JoinColumn(name = "address_id", referencedColumnName = "id") */
	private Address address;
}
