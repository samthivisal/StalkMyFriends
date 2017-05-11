package com.dant.dao;

import com.dant.entity.Account;
import com.dant.entity.dto.AccountDTO;
import org.mongodb.morphia.Datastore;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

/**
 * Created by OPERMAN Timoty on 06/05/2017.
 */
public class AccountDAO {

    private final Datastore datastore = DatastoreInit.getDatastore();

    public Account connection(String phoneNumber, String password) {
        Account account = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        if (account == null) {
            throw new NotFoundException();
        }
        if (!account.getPassword().equals(password)) {
            throw new ForbiddenException();
        }
        return account;
    }

    public Account create(AccountDTO accountDTO) {
        Account account = new Account(accountDTO);
        if (account == null) {
            throw new NotFoundException();
        }
        datastore.save(account);
        return account;
    }

}
