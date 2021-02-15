package com.georgeisaev.creditconveyor.controllers.conveyor;

import com.georgeisaev.creditconveyor.domain.conveyor.SimpleCreditConveyor;
import com.georgeisaev.creditconveyor.domain.products.CreditProduct;
import com.georgeisaev.creditconveyor.domain.products.CreditProductType;
import com.georgeisaev.creditconveyor.data.conveyor.CreditConveyorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.CAR_LOAN;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.CONSUMER;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.EXPRESS_LOAN;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.MICROLOAN;
import static com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct.BaseCreditProductType.MORTGAGE_LOAN;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("conveyor")
public class DesignCreditConveyorController {

	private final CreditConveyorRepository creditConveyorRepository;

	@Autowired
	public DesignCreditConveyorController(CreditConveyorRepository creditConveyorRepository) {
		this.creditConveyorRepository = creditConveyorRepository;
	}

	@GetMapping
	public String showDesignFrom(Model model) {
		setDesignModelAttributes(model);
		return "design";
	}

	@ModelAttribute(name = "conveyor")
	public SimpleCreditConveyor conveyor() {
		return new SimpleCreditConveyor();
	}

	@PostMapping
	public String processDesign(Model model, @Valid SimpleCreditConveyor conveyor, Errors errors) {
		if (errors.hasErrors()) {
			setDesignModelAttributes(model);
			return "design";
		}
		// TODO: Save the conveyor
		creditConveyorRepository.save(conveyor);
		log.info("Conveyor: " + conveyor);
		return "redirect:/companies/current";

	}

	private void setDesignModelAttributes(Model model) {
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
		model.addAttribute("conveyor", new SimpleCreditConveyor());
	}

}
