package com.georgeisaev.creditconveyor.domain.companies;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Company {

	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message="Address is required")
	private String address;

}
