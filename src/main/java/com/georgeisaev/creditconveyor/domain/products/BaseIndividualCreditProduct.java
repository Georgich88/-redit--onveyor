package com.georgeisaev.creditconveyor.domain.products;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BaseIndividualCreditProduct implements CreditProduct {

	private final String id;
	private final String name;
	private final CreditProductType type;

	public enum BaseCreditProductType implements CreditProductType {
		CONSUMER, EXPRESS_LOAN, MICROLOAN, CAR_LOAN, MORTGAGE_LOAN
	}

}

