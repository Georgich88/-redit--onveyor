package com.georgeisaev.creditconveyor.data.products;

import com.georgeisaev.creditconveyor.domain.products.IndividualCreditProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCreditProductRepository extends CrudRepository<IndividualCreditProduct, String> {

}
