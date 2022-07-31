package com.kedar.design.amazonorderplacement.service;

import com.kedar.design.amazonorderplacement.models.Account;
import lombok.Data;

@Data
public class LoginService {


    protected void loginToAccount(Account account) {
        //do-some-verification for valid user
        System.out.println("Welcome"+account.getName());

    }
}
