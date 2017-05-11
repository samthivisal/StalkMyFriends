package com.dant.dao;

import com.dant.entity.Account;
import com.dant.entity.Position;
import com.dant.entity.dto.AccountDTO;
import org.mongodb.morphia.Datastore;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

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
        datastore.save(account);
        return account;
    }

    public void testInitDatabase(){
        Account test = new Account("first","last","1234567890","email@mail.com","pwd",new Position(123.456,45.102));
        Account test1 = new Account("first1","last1","1234567890","email@mail.com","pwd",new Position(123.456,45.102));
        Account test2 = new Account("first3","last2","1234567890","email@mail.com","pwd",new Position(123.456,45.102));
        datastore.save(test);
        datastore.save(test1);
        datastore.save(test2);
    }

    public static void main(String[] args) {
        new AccountDAO().testInitDatabase();
    }

}
