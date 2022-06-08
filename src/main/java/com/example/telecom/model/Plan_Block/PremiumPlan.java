package com.example.telecom.model.Plan_Block;

import com.example.telecom.model.Account_Block.Account;
import com.example.telecom.model.Plan_Block.Money;

import java.math.BigDecimal;
import java.util.List;

public class PremiumPlan extends Plan {

    private Integer maxData;
    private Money overDataFee;

    public PremiumPlan(Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee, List<Account> accounts, Integer maxData, Money overDataFee) {
        super(maxMinuts, maxMessages, monthlyRate, longDistanceRate, overMinutesFee, overMessagesFee, accounts);
        this.maxData = maxData;
        this.overDataFee = overDataFee;
    }

    public PremiumPlan() {

    }

    public Integer getMaxData() {
        return maxData;
    }

    public void setMaxData(Integer maxData) {
        this.maxData = maxData;
    }

    public Money getOverDataFee() {
        return overDataFee;
    }

    public void setOverDataFee(Money overDataFee) {
        this.overDataFee = overDataFee;
    }


}
