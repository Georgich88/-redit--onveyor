package com.georgeisaev.creditconveyor.web.repositories.security;

import com.georgeisaev.creditconveyor.domain.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
