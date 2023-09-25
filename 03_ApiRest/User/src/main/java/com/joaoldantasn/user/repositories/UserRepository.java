package com.joaoldantasn.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoldantasn.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
