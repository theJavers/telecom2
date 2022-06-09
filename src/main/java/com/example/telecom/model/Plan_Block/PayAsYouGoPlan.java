package com.example.telecom.model.Plan_Block;

import com.example.telecom.model.Account_Block.Account;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;
@PrimaryKeyJoinColumn(name = "id_normal")
public class PayAsYouGoPlan extends Plan {

    public PayAsYouGoPlan(Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee, List<Account> accounts) {
        super(maxMinuts, maxMessages, monthlyRate, longDistanceRate, overMinutesFee, overMessagesFee, accounts);
    }

    public PayAsYouGoPlan () {

    }




}
