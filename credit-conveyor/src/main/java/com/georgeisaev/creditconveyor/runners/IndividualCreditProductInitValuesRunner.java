package com.georgeisaev.creditconveyor.runners;

import com.georgeisaev.creditconveyor.data.products.IndividualCreditProductRepository;
import com.georgeisaev.creditconveyor.domain.conveyor.SimpleCreditConveyor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class IndividualCreditProductInitValuesRunner implements ApplicationRunner {

	private final IndividualCreditProductRepository productRepository;

	@Autowired
	public IndividualCreditProductInitValuesRunner(IndividualCreditProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void run(ApplicationArguments args) {
		productRepository.saveAll(SimpleCreditConveyor.generateDefaultIndividualCreditProducts());
	}

}