package com.georgeisaev.creditconveyor.data.conveyor;

import com.georgeisaev.creditconveyor.domain.conveyor.SimpleCreditConveyor;
import org.springframework.data.repository.CrudRepository;

public interface CreditConveyorRepository extends CrudRepository<SimpleCreditConveyor, Long> {

}
