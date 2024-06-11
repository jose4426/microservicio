package com.example.microservicio_demo.repository;

import com.example.microservicio_demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
