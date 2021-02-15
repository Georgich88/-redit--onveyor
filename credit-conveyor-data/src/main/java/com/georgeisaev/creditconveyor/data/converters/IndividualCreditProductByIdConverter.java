package com.georgeisaev.creditconveyor.data.converters;

import com.georgeisaev.creditconveyor.data.products.IndividualCreditProductRepository;
import com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IndividualCreditProductByIdConverter implements Converter<String, IndividualCreditProduct> {

	private final IndividualCreditProductRepository productRepository;

	@Autowired
	public IndividualCreditProductByIdConverter(IndividualCreditProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public IndividualCreditProduct convert(String id) {
		Optional<IndividualCreditProduct> product = productRepository.findById(id);
		return product.orElse(null);
	}

}
