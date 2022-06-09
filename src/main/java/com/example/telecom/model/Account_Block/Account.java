package com.example.telecom.model.Account_Block;

import com.example.telecom.model.Plan_Block.Plan;
import com.example.telecom.model.User_Block.User;
import org.hibernate.boot.model.source.spi.PluralAttributeNature;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Enumerated
    private Status status;
    @ManyToMany
    @JoinTable(name = "account_users")
    private List<User> users;
   @OneToOne
    private User primaryUser;
   @ManyToOne
   @JoinColumn(name="plan_id")
    private Plan plan;

    public Account(Status status, List<User> users, User primaryUser, Plan plan) {
        this.status = status;
        this.users = users;
        this.primaryUser = primaryUser;
        this.plan = plan;
    }

    public Account(){
    }



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
