package com.georgeisaev.creditconveyor.domain.conveyor;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@RequiredArgsConstructor
public class BaseCreditConveyor implements CreditConveyor {

	@NotBlank(message = "Name is required")
	private final String name;
	@Size(min = 1, message = "You must choose at least 1 credit product")
	private final List<String> products;

}
