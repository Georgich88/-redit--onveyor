package com.georgeisaev.creditconveyor.web.repositories.companies;

import com.georgeisaev.creditconveyor.domain.companies.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
