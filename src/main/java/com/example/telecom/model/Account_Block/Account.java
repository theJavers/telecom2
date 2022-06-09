package com.example.telecom.model.Account_Block;

import com.example.telecom.model.Plan_Block.Plan;
import com.example.telecom.model.User_Block.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.boot.model.source.spi.PluralAttributeNature;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JsonIgnore
    @JoinTable(
            name = "users_account",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "account_id") }
    )
    private List<User> users = new ArrayList<>();
   @OneToOne
    private User primaryUser;
   @ManyToOne
   @JsonIgnore
   @JoinColumn(name="plan_id")
    private Plan plan;

    public Account(Status status, User primaryUser, Plan plan) {
        this.status = status;
        //this.users = users;
        this.primaryUser = primaryUser;
        this.plan = plan;
    }

    public Account(){
    }

    ///////////////////////////
    public void addUser(User user){
        users.add(user);
    }

    ///////////////////////////









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
