package com.example.telecom.repository;

import com.example.telecom.model.User_Block.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            value = "SELECT * from user WHERE user.name = :name",
            nativeQuery = true)
    User findUserByName(@Param("name") String name);


    @Query(
            value = "SELECT * from user WHERE user.phone_number = :number",
            nativeQuery = true)
    User findUserByPhoneNumber(@Param("number") String number);

}
