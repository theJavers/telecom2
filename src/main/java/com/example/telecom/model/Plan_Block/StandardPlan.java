package com.example.telecom.model.Plan_Block;

import com.example.telecom.model.Account_Block.Account;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;
@Entity
public class StandardPlan extends Plan{

    private Integer maxData;
    @Embedded
    private Money overDataFee;

    public StandardPlan(Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee,  Integer maxData, Money overDataFee) {
        super(maxMinuts, maxMessages, monthlyRate, longDistanceRate, overMinutesFee, overMessagesFee);
        this.maxData = maxData;
        this.overDataFee = overDataFee;
    }

    public StandardPlan () {

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
