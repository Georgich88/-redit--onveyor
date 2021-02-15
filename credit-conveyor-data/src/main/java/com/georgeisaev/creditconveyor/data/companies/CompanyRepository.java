package com.georgeisaev.creditconveyor.data.companies;

import com.georgeisaev.creditconveyor.domain.companies.Company;
import com.georgeisaev.creditconveyor.domain.security.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

	List<Company> findCompaniesByCeoOrderByTinDesc(User user, Pageable pageable);

}
