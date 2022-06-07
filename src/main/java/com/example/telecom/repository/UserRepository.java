package com.example.telecom.repository;

import com.example.telecom.model.User_Block.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository {
    public User findByName(String name);
}
