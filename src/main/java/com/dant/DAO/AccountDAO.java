package com.dant.dao;

import com.dant.entity.Account;
import com.dant.entity.Position;
import com.dant.entity.dto.AccountDTO;
import com.mongodb.operation.OperationExecutor;
import com.mongodb.operation.UpdateOperation;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void delete(String phoneNumber, String password) {
        Account account = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        if (account == null) {
            throw new NotFoundException();
        }
        if (!account.getPassword().equals(password)) {
            throw new ForbiddenException();
        } else {
            datastore.delete(account);
        }

    }

    public List<Account> findUserByName(String partName) {
        String partNameWord[] = partName.split(" ");
        String regex = "";
        for (String part : partNameWord) {
            part = "(?=.*" + part + ")";
            regex+=part;
        }
        System.out.println(regex);
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        List<Account> accounts = datastore.find(Account.class).filter("fullName", pattern).order("fullName").asList();
        return accounts;
    }

    public void updateLocation(String token, Position position) {
        //TODO: si l'user n"est pas connecté
        Key<Account> key = datastore.find(Account.class).field("token").equal(token).getKey();
        UpdateOperations<Account> operation = datastore.createUpdateOperations(Account.class).set("location", position);
        datastore.update(key, operation);
    }

    public void testInitDatabase() {
        Account test = new Account("first", "last", "1234567890", "email@mail.com", "pwd", new Position(123.456, 45.102));
        Account test1 = new Account("first1", "LAST1", "1234567890", "email@mail.com1", "pwd", new Position(123.456, 45.102));
        Account test2 = new Account("first2", "last2", "1234567890", "email@mail.com2", "pwd", new Position(123.456, 45.102));
        datastore.save(test);
        datastore.save(test1);
        datastore.find(Account.class).field("firstName").equal("first").get();
        datastore.save(test2);
    }

    public static void main(String[] args) {
        AccountDAO test = new AccountDAO();
//        new AccountDAO().testInitDatabase();
//        new AccountDAO().updateLocation("591189fa2ff84c31c0917700",new Position(123.456,321.0));
//        System.out.println(test.findUserByName("first last"));
    }


}
