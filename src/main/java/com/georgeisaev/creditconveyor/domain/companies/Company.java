package com.georgeisaev.creditconveyor.domain.companies;

import com.georgeisaev.creditconveyor.domain.security.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Company {

	@Id
	private String tin;

	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Address is required")
	private String address;

	@ManyToOne
	private User ceo;

}
