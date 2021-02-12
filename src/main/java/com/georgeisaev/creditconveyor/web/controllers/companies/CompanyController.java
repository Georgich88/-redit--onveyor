package com.georgeisaev.creditconveyor.web.controllers.companies;

import com.georgeisaev.creditconveyor.domain.companies.Company;
import com.georgeisaev.creditconveyor.domain.security.User;
import com.georgeisaev.creditconveyor.web.repositories.companies.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@GetMapping("/current")
	public String companyForm(Model model) {
		model.addAttribute("company", new Company());
		return "companyForm";
	}

	@PostMapping
	public String processCompany(@Valid Company company, Errors errors, @AuthenticationPrincipal User user) {
		if (errors.hasErrors()) {
			return "companyForm";
		}
		company.setCeo(user);
		companyRepository.save(company);
		return "redirect:/";
	}

}
