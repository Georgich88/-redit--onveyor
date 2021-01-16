package com.georgeisaev.creditconveyor.domain.conveyor;

import com.georgeisaev.creditconveyor.domain.products.BaseIndividualCreditProduct;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class BaseCreditConveyor implements CreditConveyor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@NotBlank(message = "Name is required")
	private String name;

	private LocalDate createdAt;

	@ManyToMany
	@Size(min = 1, message = "You must choose at least 1 credit product")
	private List<BaseIndividualCreditProduct> products;

	@PrePersist
	void createdAt() {
		this.createdAt = LocalDate.now();
	}

}
