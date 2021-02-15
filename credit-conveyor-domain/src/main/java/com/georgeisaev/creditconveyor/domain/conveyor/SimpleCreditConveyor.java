package com.georgeisaev.creditconveyor.domain.conveyor;

import com.georgeisaev.creditconveyor.domain.products.CreditProduct;
import com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct;
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
import java.util.stream.Collectors;

import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.CAR_LOAN;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.CONSUMER;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.EXPRESS_LOAN;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.MICROLOAN;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.MORTGAGE_LOAN;

@Data
@Entity
public class SimpleCreditConveyor implements CreditConveyor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@NotBlank(message = "Name is required")
	private String name;

	private LocalDate createdAt;

	@ManyToMany
	@Size(min = 1, message = "You must choose at least 1 credit product")
	private List<IndividualCreditProduct> products;

	@PrePersist
	void createdAt() {
		this.createdAt = LocalDate.now();
	}

	public static List<IndividualCreditProduct> generateDefaultIndividualCreditProducts() {
		return List.of(CreditProduct.of("CONSUMER-EDU-1", "Education loan", CONSUMER),
				CreditProduct.of("CONSUMER-RLS-1", "Consumer loan secured by real estate", CONSUMER),
				CreditProduct.of("EXPRESS-LOAN-1", "Express loan", EXPRESS_LOAN),
				CreditProduct.of("MICROLOAN", "Microloan", MICROLOAN),
				CreditProduct.of("CAR-LOAN-NEW-1", "New car loan", CAR_LOAN),
				CreditProduct.of("CAR-LOAN-MILEAGE-1", "Mileage car loan", CAR_LOAN),
				CreditProduct.of("MORTGAGE-LOAN-1", "Mortgage loan", MORTGAGE_LOAN))
				.stream()
				.map(IndividualCreditProduct.class::cast).collect(Collectors.toList());
	}

}
