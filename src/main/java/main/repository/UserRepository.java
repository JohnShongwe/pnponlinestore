package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.User;

@Repository("userRepository") //Mark this interface as a Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}
