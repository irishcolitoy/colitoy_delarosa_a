package com.ws101.colitoy_delarosa_a.EcommerceApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}