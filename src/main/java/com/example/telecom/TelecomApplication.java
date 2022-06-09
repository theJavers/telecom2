package com.example.telecom;

import com.example.telecom.model.Account_Block.Account;
import com.example.telecom.model.Account_Block.Status;
import com.example.telecom.model.Plan_Block.*;
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

import java.math.BigDecimal;
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
		PostalCode p2 = new PostalCode("09720");
		postalCodeRepository.save(p1);
		postalCodeRepository.save(p2);

		PayAsYouGoPlan planNormal= new PayAsYouGoPlan(100, 50, new Money(new BigDecimal(150)), new Money(new BigDecimal(250)), new Money(new BigDecimal(20)), new Money(new BigDecimal(15)));
		planRepository.save(planNormal);
		PremiumPlan planPremium = new PremiumPlan(80, 100, new Money(new BigDecimal(150)), new Money(new BigDecimal(250)), new Money(new BigDecimal(20)), new Money(new BigDecimal(15)), 10, new Money(new BigDecimal(10)));
		planRepository.save(planPremium);
		StandardPlan planStandar = new StandardPlan(90, 90, new Money(new BigDecimal(150)), new Money(new BigDecimal(250)), new Money(new BigDecimal(20)), new Money(new BigDecimal(15)), 10, new Money(new BigDecimal(10)));
		planRepository.save(planStandar);


		/////////////// USER 1 ///////////////////////////

		Address a1 = new Address("calleJuela", "Barcelona", "Spain", p1);

		User u1 = new User("Miki", a1, a1, "608555632");
		userRepository.save(u1);

		Account acc1 = new Account(Status.ACTIVE, u1, planPremium);
		accountRepository.save(acc1);

		u1.addAccount(acc1);
		userRepository.save(u1);

		acc1.addUser(u1);
		accountRepository.save(acc1);




		////////////////  USER 2 ////////////////////


		Address a2 = new Address("streeet", "Martorell", "Moon", p2);

		User u2 = new User("Adri", a2, a2, "6666666666");
		userRepository.save(u2);

		Account acc2 = new Account(Status.DELINQUENT, u2, planStandar);
		accountRepository.save(acc2);

		u2.addAccount(acc2);
		userRepository.save(u2);

		acc2.addUser(u2);
		accountRepository.save(acc2);


		///////////////  USER 3  /////////////////////


		Address a3 = new Address("streetLife", "Namibia", "Andorra", p1);

		User u3 = new User("Marina", a3, a3, "123456789");
		userRepository.save(u3);

		Account acc3 = new Account(Status.CANCELLED, u3, planNormal);
		accountRepository.save(acc3);

		u3.addAccount(acc3);
		userRepository.save(u3);

		acc3.addUser(u3);
		accountRepository.save(acc3);

		///////////////    USER 4   /////////////////////


		Address a4 = new Address("Strasse", "NY", "LKAJSD", p1);

		User u4 = new User("Ale", a4, a4, "00000000");
		userRepository.save(u4);

		Account acc4 = new Account(Status.DELINQUENT, u4, planStandar);
		accountRepository.save(acc4);

		u4.addAccount(acc4);
		userRepository.save(u4);

		acc4.addUser(u4);
		accountRepository.save(acc4);


		///////////////    USER 5   /////////////////////


		Address a5 = new Address("Strut", "Another city", "Kazaghstan", p2);

		User u5 = new User("Aleix", a5, a5, "987654321");
		userRepository.save(u5);

		Account acc5 = new Account(Status.ACTIVE, u4, planPremium);
		accountRepository.save(acc5);

		u5.addAccount(acc5);
		userRepository.save(u5);

		acc5.addUser(u5);
		accountRepository.save(acc5);


	}
}
