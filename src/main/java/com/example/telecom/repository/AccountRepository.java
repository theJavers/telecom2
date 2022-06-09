package com.example.telecom.repository;

import com.example.telecom.model.Account_Block.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(
            value = "SELECT * from account JOIN USER ON user.user_id = account.primary_user_user_id WHERE user.phone_number = :number",
            nativeQuery = true)
    Account findAccountByPrimaryPhoneNumber(@Param("number") String number);

    @Query(
            value = "SELECT status, COUNT(status) FROM account WHERE status = :status GROUP BY status",
            nativeQuery = true)
    Object findCountofAccountsByStatus(@Param("status") String status);

}
