package com.example.telecom.model.Plan_Block;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String planId;
    private Integer maxMinuts;
    private Integer maxMessages;
    private Money monthlyRate;
    private Money longDistanceRate;
    private Money overMinutesFee;
    private Money overMessagesFee;

    public Plan(String id, Integer maxMinuts, Integer maxMessages, Money monthlyRate, Money longDistanceRate, Money overMinutesFee, Money overMessagesFee) {
        this.planId = id;
        this.maxMinuts = maxMinuts;
        this.maxMessages = maxMessages;
        this.monthlyRate = monthlyRate;
        this.longDistanceRate = longDistanceRate;
        this.overMinutesFee = overMinutesFee;
        this.overMessagesFee = overMessagesFee;
    }

    public Plan () {

    }

    public Integer getMaxMinuts() {
        return maxMinuts;
    }

    public void setMaxMinuts(Integer maxMinuts) {
        this.maxMinuts = maxMinuts;
    }

    public Integer getMaxMessages() {
        return maxMessages;
    }

    public void setMaxMessages(Integer maxMessages) {
        this.maxMessages = maxMessages;
    }

    public Money getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(Money monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public Money getLongDistanceRate() {
        return longDistanceRate;
    }

    public void setLongDistanceRate(Money longDistanceRate) {
        this.longDistanceRate = longDistanceRate;
    }

    public Money getOverMinutesFee() {
        return overMinutesFee;
    }

    public void setOverMinutesFee(Money overMinutesFee) {
        this.overMinutesFee = overMinutesFee;
    }

    public Money getOverMessagesFee() {
        return overMessagesFee;
    }

    public void setOverMessagesFee(Money overMessagesFee) {
        this.overMessagesFee = overMessagesFee;
    }
}
