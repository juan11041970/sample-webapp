package com.jda.dao

import com.jda.bo.Account
import org.junit.Test

class TestAccountDAO {

    Account a1 = new Account(1, 100)
    Account a2 = new Account(2, 100)

    def accounts = [1:a1, 2:a2]
    def currentId = 2

    def mock = [
            findAccountById: {
                int id -> accounts[id]
            },
            findAllAccounts: {
                -> accounts.values()
            },
            createNewAccount: {
                double balance -> currentId++
                    println "current id was increased to ${currentId}"
            },
            deleteAccount: {
                int id ->
            }
    ] as AccountDAO

    @Test
    public void testMock() {

        assert mock.findAccountById(1) == a1

        mock.findAllAccounts().each{
            assert accounts.containsValue(it)
        }

        mock.createNewAccount(200)
        assert 3 == currentId
    }
}
