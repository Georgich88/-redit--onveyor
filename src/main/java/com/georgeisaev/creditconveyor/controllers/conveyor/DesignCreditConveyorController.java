package com.georgeisaev.creditconveyor.controllers.conveyor;

import com.georgeisaev.creditconveyor.domain.conveyor.BaseCreditConveyor;
import com.georgeisaev.creditconveyor.domain.products.CreditProduct;
import com.georgeisaev.creditconveyor.domain.products.CreditProductType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.georgeisaev.creditconveyor.domain.products.BaseIndividualCreditProduct.BaseCreditProductType.CAR_LOAN;
import static com.georgeisaev.creditconveyor.domain.products.BaseIndividualCreditProduct.BaseCreditProductType.CONSUMER;
import static com.georgeisaev.creditconveyor.domain.products.BaseIndividualCreditProduct.BaseCreditProductType.EXPRESS_LOAN;
import static com.georgeisaev.creditconveyor.domain.products.BaseIndividualCreditProduct.BaseCreditProductType.MICROLOAN;
import static com.georgeisaev.creditconveyor.domain.products.BaseIndividualCreditProduct.BaseCreditProductType.MORTGAGE_LOAN;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignCreditConveyorController {

	@GetMapping
	public String showDesignFrom(Model model) {
		List<CreditProduct> products = List.of(
				CreditProduct.of("CONSUMER-EDU-1", "Education loan", CONSUMER),
				CreditProduct.of("CONSUMER-RLS-1", "Consumer loan secured by real estate", CONSUMER),
				CreditProduct.of("EXPRESS-LOAN-1", "Express loan", EXPRESS_LOAN),
				CreditProduct.of("MICROLOAN", "Microloan", MICROLOAN),
				CreditProduct.of("CAR-LOAN-NEW-1", "New car loan", CAR_LOAN),
				CreditProduct.of("CAR-LOAN-MILEAGE-1", "Mileage car loan", CAR_LOAN),
				CreditProduct.of("MORTGAGE-LOAN-1", "Mortgage loan", MORTGAGE_LOAN)
		);
		Map<CreditProductType, List<CreditProduct>> productByType = products.stream()
				.collect(Collectors.groupingBy(CreditProduct::getType));
		for (var entry : productByType.entrySet()) {
			model.addAttribute(entry.getKey().toString().toLowerCase(), entry.getValue());
		}
		model.addAttribute("design", new BaseCreditConveyor(""));
		return "design";
	}

}
