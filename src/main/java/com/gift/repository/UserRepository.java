package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gift.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
