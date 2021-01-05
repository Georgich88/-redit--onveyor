package com.georgeisaev.creditconveyor.domain.products;

public interface CreditProduct {

	static CreditProduct of(String code, String name, CreditProductType type) {
		return new BaseIndividualCreditProduct(code, name, type);
	}

	CreditProductType getType();

}
