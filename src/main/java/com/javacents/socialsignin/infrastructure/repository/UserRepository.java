package com.javacents.socialsignin.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacents.socialsignin.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);

}
