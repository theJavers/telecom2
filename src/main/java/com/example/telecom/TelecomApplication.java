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

		Address a1 = new Address("calle1", "Barcelona", "Spain", p1);
		Address a2 = new Address("calle2", "Madrid", "France", p1);
		Address a3 = new Address("calle3", "Miculo", "Youvan", p2);

		Account acc1 = new Account();
		Account acc2 = new Account();
		Account acc3 = new Account();
		Account acc4 = new Account();
		Account acc5 = new Account();
		accountRepository.save(acc1);
		accountRepository.save(acc2);
		accountRepository.save(acc3);
		accountRepository.save(acc4);
		accountRepository.save(acc5);

		List<Account> list1 = new ArrayList<>();
		list1.add(acc1);
		list1.add(acc2);
		List<Account> list2 = new ArrayList<>();
		list2.add(acc3);

		User u1 = new User("Ale", a1, a2, "608555632", list1);
		userRepository.save(u1);
		User u2 = new User("Adri", a1, a2, "655555552", list2);
		userRepository.save(u2);
		User u3 = new User("Johny Walker", a3, a3, "879658426",list2);
		userRepository.save(u3);

		acc1.setStatus(Status.ACTIVE);
		acc1.setPrimaryUser(u1);
		acc1.setPlan(planPremium);

		acc2.setStatus(Status.ACTIVE);
		acc2.setPrimaryUser(u2);
		acc2.setPlan(planStandar);

		acc3.setStatus(Status.ACTIVE);
		acc3.setPrimaryUser(u3);
		acc3.setPlan(planNormal);

		acc4.setStatus(Status.DELINQUENT);
		acc4.setPrimaryUser(u1);
		acc4.setPlan(planPremium);

		acc5.setStatus(Status.CANCELLED);
		acc5.setPrimaryUser(u2);
		acc5.setPlan(planStandar);

		accountRepository.save(acc1);
		accountRepository.save(acc2);
		accountRepository.save(acc3);
		accountRepository.save(acc4);
		accountRepository.save(acc5);

		/*
		Account acc1 = new Account(Status.ACTIVE, u1, planNormal);
		Account acc2 = new Account(Status.CANCELLED, u2, planPremium);
		Account acc3 = new Account(Status.DELINQUENT, u3, planStandar);
		Account acc4 = new Account(Status.ACTIVE, u3, planNormal);
		Account acc5 = new Account(Status.DELINQUENT, u3, planPremium);
		 */


/*
		u1.setAccounts(List.of(acc1, acc2));
		userRepository.save(u1);
		u2.setAccounts(List.of(acc3));
		userRepository.save(u2);
		u3.setAccounts((List.of(acc4, acc5)));
		userRepository.save(u2);

*/



	}
}
