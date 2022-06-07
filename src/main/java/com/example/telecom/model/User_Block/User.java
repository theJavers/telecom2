package com.example.telecom.model.User_Block;

import com.example.telecom.model.Account_Block.Account;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private Address shippingAddress;
    private Address billingAddress;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    public User(){}

    public User(String name, Address shippingAddress, Address billingAddress, String phoneNumber, List<Account> accounts) {
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }
}
