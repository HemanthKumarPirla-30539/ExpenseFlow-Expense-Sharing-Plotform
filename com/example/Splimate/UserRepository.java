package com.example.Splimate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);

	User findByEmail(String email);
	List<User> findByUsernameContaining(String username);
}
