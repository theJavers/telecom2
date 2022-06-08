package com.example.telecom.model.Account_Block;

import com.example.telecom.model.Plan_Block.Plan;
import com.example.telecom.model.User_Block.User;
import org.hibernate.boot.model.source.spi.PluralAttributeNature;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Enumerated
    private Status status;
    private Map<User, String> userPhoneMap;
   @OneToOne
    private User primaryUser;
   @ManyToOne
   @JoinColumn(name="plan_id")
   private Plan plan;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public Account(){}

    public Account(Status status, Map<User, String> userPhoneMap, User primaryUser, Plan plan) {
        this.status = status;
        this.userPhoneMap = userPhoneMap;
        this.primaryUser = primaryUser;
        this.plan = plan;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<User, String> getUserPhoneMap() {
        return userPhoneMap;
    }

    public void setUserPhoneMap(Map<User, String> userPhoneMap) {
        this.userPhoneMap = userPhoneMap;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
