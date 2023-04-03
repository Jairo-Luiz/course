package com.educandoweb.course.repositorios;

import com.educandoweb.course.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
