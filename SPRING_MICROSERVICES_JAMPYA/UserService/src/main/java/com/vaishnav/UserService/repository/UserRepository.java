package com.vaishnav.UserService.repository;

import com.vaishnav.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long userId);
}
