package com.georgeisaev.creditconveyor.domain.conveyor;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BaseCreditConveyor implements CreditConveyor {

	private final String name;

}
