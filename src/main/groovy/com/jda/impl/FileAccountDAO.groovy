package com.jda.impl

import com.jda.bo.Account
import com.jda.dao.AccountDAO

class FileAccountDAO implements AccountDAO {

    File accountsFile
    Map<Integer, Account> accounts = [:]
    private static int nextId
    boolean dirty

    private void readAccountFromFile() {

        accountsFile.splintEachLinf(',') { line ->
            int id = line[0].toInteger()
            double balance = line[1].toDouble()
            accounts[id] = new Account(id: id, balance: balance)
        }
        nextId = accounts?.keySet().max() ? 0 : nextId++
        dirty = false
    }

    private void writeAccountToFile() {

        accountsFile.withWriter {w ->
            accounts.each{ id, account ->
                w.println("$id, $account.balance")
            }
        }
    }

    Account findAccountById(int id) {

        if (dirty) {
            readAccountFromFile()
        }
        return accounts[id]
    }

    Collection<Account> findAllAccounts() {

        if (dirty) {
            readAccountFromFile()
        }
        return accounts.values()
    }

    int createNewAccount(double balance) {

        int newId = nextId++
        accounts[newId] = new Account(id: newId, balance: balance)
        writeAccountToFile()
        return newId

    }

    void deleteAccount(int id) {

        accounts.remove(id)
        writeAccountToFile()
    }
}
