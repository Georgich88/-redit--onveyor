package com.georgeisaev.creditconveyor.domain.products;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class IndividualCreditProduct implements CreditProduct {

	@Id
	private final String id;
	private final String name;
	private final BaseCreditProductType type;

	public enum BaseCreditProductType implements CreditProductType {
		CONSUMER, EXPRESS_LOAN, MICROLOAN, CAR_LOAN, MORTGAGE_LOAN
	}

}

