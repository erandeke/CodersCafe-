package com.kedar.flight.reservation.user;

public class Account {
    private Long accountId;
    private String userName;
    private String password;
    private Contact contact;

    public Account createNewAccount() {
        return new Account();
    }
}
