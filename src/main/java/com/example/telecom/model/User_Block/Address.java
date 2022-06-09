package com.example.telecom.model.User_Block;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Address {


    private String street;
    private String city;
    private String country;
    @ManyToOne
    @JoinColumn(nullable = false)
    private PostalCode postalCode;


    public Address() {
    }

    public Address(String street, String city, String country, PostalCode postalCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getStreetAddress() {
        return street;
    }

    public void setStreetAddress(String streetAddress) {
        this.street = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
