package com.example.telecom.model.User_Block;

import com.example.telecom.model.Account_Block.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name ="street_shipping")),
            @AttributeOverride(name = "city", column = @Column(name ="city_shipping")),
            @AttributeOverride(name = "country", column = @Column(name = "country_shipping")),
            //@AttributeOverride(name = "postalCode", column = @Column(name = "postalCode_id_shipping"))
    })
    @AssociationOverrides({
            @AssociationOverride(name = "postalCode", joinColumns = @JoinColumn(name ="postalCode_id_Shipping")),
    })

    private Address shippingAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name ="street_billing")),
            @AttributeOverride(name = "city", column = @Column(name ="city_billing")),
            @AttributeOverride(name = "country", column = @Column(name = "country_billing")),
            //@AttributeOverride(name = "postalCode", column = @Column(name = "postalCode_id_billing"))
    })
    @AssociationOverrides({
            @AssociationOverride(name = "postalCode", joinColumns = @JoinColumn(name ="postalCode_id_Billing")),
    })
    private Address billingAddress;
    private String phoneNumber;
    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Account> accounts;

    public User(){}

    public User(String name, Address shippingAddress, Address billingAddress, String phoneNumber, List<Account> accounts) {
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
