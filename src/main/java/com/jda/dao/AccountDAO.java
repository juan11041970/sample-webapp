package com.jda.dao;

import com.jda.bo.Account;

import java.util.Collection;

public interface AccountDAO {

    Account findAccountById(int id);
    Collection<Account> findAllAccounts();
    int createNewAccount(double balance);
    void deleteAccount(int id);
}
