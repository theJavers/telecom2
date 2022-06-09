package com.example.telecom.model.Plan_Block;

import com.example.telecom.model.Account_Block.Account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import java.util.List;


@Entity
public class PayAsYouGoPlan extends Plan {

    public PayAsYouGoPlan(Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee) {
        super(maxMinuts, maxMessages, monthlyRate, longDistanceRate, overMinutesFee, overMessagesFee);
    }

    public PayAsYouGoPlan () {

    }






}
