package com.georgeisaev.creditconveyor.controllers.companies;

import com.georgeisaev.creditconveyor.domain.companies.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/companies")
public class CompanyController {

	@GetMapping("/current")
	public String companyForm(Model model) {
		model.addAttribute("company", new Company());
		return "companyForm";
	}

	@PostMapping
	public String processCompany(@Valid Company company, Errors errors) {
		if (errors.hasErrors()){
			return "companyForm";
		}
		log.info("Created company: " + company);
		return "redirect:/";
	}

}
