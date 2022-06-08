package com.example.telecom.model.Plan_Block;

import com.example.telecom.model.Account_Block.Account;

import javax.persistence.*;

@Entity
public abstract class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String planId;
    private Integer maxMinuts;
    private Integer maxMessages;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "USD", column = @Column(name = "monthlyRateUSD")),
            @AttributeOverride(name = "DEFAULT_ROUNDING", column = @Column(name = "monthlyRateDefaultRounding")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthlyRateCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "monthlyRateAmount"))
    })
    private Money monthlyRate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "USD", column = @Column(name = "longDistanceRateUSD")),
            @AttributeOverride(name = "DEFAULT_ROUNDING", column = @Column(name = "longDistanceRateRounding")),
            @AttributeOverride(name = "currency", column = @Column(name = "longDistanceRateCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "longDistanceRateAmount"))
    })
    private Money longDistanceRate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "USD", column = @Column(name = "overMinutesFeeUSD")),
            @AttributeOverride(name = "DEFAULT_ROUNDING", column = @Column(name = "overMinutesFeeRounding")),
            @AttributeOverride(name = "currency", column = @Column(name = "overMinutesFeeCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "overMinutesFeeAmount"))
    })
    private Money overMinutesFee;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "USD", column = @Column(name = "overMessagesFeeUSD")),
            @AttributeOverride(name = "DEFAULT_ROUNDING", column = @Column(name = "overMessagesFeeDefaultRounding")),
            @AttributeOverride(name = "currency", column = @Column(name = "overMessagesFeeCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "overMessagesFeeAmount"))
    })
    private Money overMessagesFee;

    @ManyToOne

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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
