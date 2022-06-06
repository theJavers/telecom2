package com.example.telecom.model.Plan_Block;

public class StandardPlan extends Plan{

    private Integer maxData;
    private Money overDataFee;

    public StandardPlan(String id, Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee, Integer maxData, Money overDataFee) {
        super(id, maxMinuts, maxMessages, monthlyRate, longDistanceRate, overMinutesFee, overMessagesFee);
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
