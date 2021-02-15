package com.georgeisaev.creditconveyor.domain.products;

import com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType;

public interface CreditProduct {

	static IndividualCreditProduct of(String code, String name, BaseCreditProductType type) {
		return new IndividualCreditProduct(code, name, type);
	}

	CreditProductType getType();

}
