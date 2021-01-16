package com.georgeisaev.creditconveyor.domain.clients;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name = "clients_individuals")
public class Individual {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "First name should not be empty")
	private String firstName;
	private String middleName;
	@NotBlank(message = "Second name should not be empty")
	private String secondName;

	private Date birthday;

}
