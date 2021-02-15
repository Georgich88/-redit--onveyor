package com.georgeisaev.creditconveyor.controllers.companies;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Component
@ConfigurationProperties(prefix = "conveyor.companies")
@Validated
public class CompanyProperties {

	private static final int DEFAULT_PAGE_SIZE = 20;
	@Min(value = 5, message = "must be between 5 and 25")
	@Max(value = 25, message = "must be between 5 and 25")
	private int pageSize = DEFAULT_PAGE_SIZE;

}
