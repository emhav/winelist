package hh.swd20.Winelist.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserReposiotry extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
}