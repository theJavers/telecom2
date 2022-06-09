package com.example.telecom;

import com.example.telecom.model.Account_Block.Account;
import com.example.telecom.model.User_Block.Address;
import com.example.telecom.model.User_Block.PostalCode;
import com.example.telecom.model.User_Block.User;
import com.example.telecom.repository.AccountRepository;
import com.example.telecom.repository.PlanRepository;
import com.example.telecom.repository.PostalCodeRepository;
import com.example.telecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TelecomApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PlanRepository planRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	PostalCodeRepository postalCodeRepository;


	public static void main(String[] args) {
		SpringApplication.run(TelecomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PostalCode p1 = new PostalCode("08930");
		postalCodeRepository.save(p1);

		Address a1 = new Address("calle1", "Barcelona", "Spain", p1);
		Address a2 = new Address("calle2", "Barcelon2", "Spain2", p1);

		Account acc1 = new Account();
		Account acc2 = new Account();

		List<Account> accList = new ArrayList<>();
		accList.add(acc1);
		accList.add(acc2);

		User u1 = new User("Ale", a1, a2, "608555632", accList);
		acc1 = accountRepository.save(acc1);
		acc2 = accountRepository.save(acc2);

		u1 = userRepository.save(u1);

		u1.setAccounts(List.of(acc1));
		userRepository.save(u1);




	}
}
