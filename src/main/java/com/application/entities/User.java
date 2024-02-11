package com.application.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;



    private String userId;
    private String firstName;
    private String email;
    private String password;
    private String address;
    private String mobile;

    public User() {
    }

    public User(Long id,
                  String firstName,
                  String email,
                  String password,
                  String address,
                  String mobile,
                  String userId)
    {
        this.id=id;
        this.firstName=firstName;
        this.email=email;
        this.password=password;
        this.address=address;
        this.mobile=mobile;
        this.userId=userId;
    }

    public User(String firstName,
                  String email,
                  String password,
                  String address,
                  String mobile,
                  String userId)
    {
        this.userId=userId;
        this.firstName=firstName;
        this.email=email;
        this.password=password;
        this.address=address;
        this.mobile=mobile;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

