package com.georgeisaev.creditconveyor.domain.creditapplications;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name = "credit_applications_individuals")
public class IndividualLoanApplication implements CreditApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date createdAt;

	@NotBlank(message="Application name is required")
	private String applicationName;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

}
