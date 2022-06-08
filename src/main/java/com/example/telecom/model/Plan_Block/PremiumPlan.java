package com.example.telecom.model.Plan_Block;

import com.example.telecom.model.Plan_Block.Money;

import java.math.BigDecimal;

public class PremiumPlan extends Plan {

    private Integer maxData;
    private Money overDataFee;

    public PremiumPlan(String id, Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee, Integer maxData, Money overDataFee) {
        super(id, maxMinuts, maxMessages, monthlyRate, longDistanceRate, overMinutesFee, overMessagesFee);
        super.setLongDistanceRate(new Money(new BigDecimal(0)));
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
