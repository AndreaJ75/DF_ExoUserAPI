package com.bnppf.df.upskilling.repository;

import com.bnppf.df.upskilling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
