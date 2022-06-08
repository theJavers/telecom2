package com.example.telecom.repository;

import com.example.telecom.model.Account_Block.Account;
import com.example.telecom.model.User_Block.Address;
import com.example.telecom.model.User_Block.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
