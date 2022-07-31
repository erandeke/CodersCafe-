package com.kedar.design.amazonorderplacement.models;

import lombok.Data;

import java.util.List;

@Data
public class Account extends  BaseUser {
    private String name;
    private String password;
    private String emailAddress;
    private List<Address> addressList;
    private List<ContactDetails> contactDetails;


}
