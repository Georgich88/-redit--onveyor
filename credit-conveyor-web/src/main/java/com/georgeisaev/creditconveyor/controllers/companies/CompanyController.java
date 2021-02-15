package com.georgeisaev.creditconveyor.controllers.companies;

import com.georgeisaev.creditconveyor.domain.companies.Company;
import com.georgeisaev.creditconveyor.domain.security.User;
import com.georgeisaev.creditconveyor.data.companies.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/companies")
@SessionAttributes("company")
public class CompanyController {

	private final CompanyRepository companyRepository;
	private final CompanyProperties companyProperties;

	@Autowired
	public CompanyController(CompanyRepository companyRepository, CompanyProperties companyProperties) {
		this.companyRepository = companyRepository;
		this.companyProperties = companyProperties;
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

	@GetMapping
	public String companiesByUser(@AuthenticationPrincipal User user, Model model) {
		Pageable pageable = PageRequest.of(0, companyProperties.getPageSize());
		model.addAttribute("companies", companyRepository.findCompaniesByCeoOrderByTinDesc(user, pageable));
		return "companiesList";
	}


}
