package com.gift.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gift.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findFirstByUsername(String username);

}
