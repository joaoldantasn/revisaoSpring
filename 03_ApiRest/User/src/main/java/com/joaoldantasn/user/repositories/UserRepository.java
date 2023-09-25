package com.joaoldantasn.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoldantasn.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
