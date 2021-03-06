package com.dant.dao;

import com.dant.entity.Account;
import com.dant.entity.Position;
import com.dant.entity.dto.AccountDTO;
import org.bson.types.ObjectId;
import com.mongodb.operation.OperationExecutor;
import com.mongodb.operation.UpdateOperation;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountDAO {

    private final Datastore datastore = DatastoreInit.getDatastore();

    public AccountDTO connection(String phoneNumber, String password) {
        //Account account = datastore.createQuery(Account.class).filter("phoneNumber", phoneNumber).get();
        Account account = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        if (account == null) {
            System.out.println("Pas de compte");
            throw new NotFoundException();
        }
        if (!account.getPassword().equals(password)) {
            System.out.println("Pas bon mdp");
            throw new ForbiddenException();
        }
        account.connect(true);
        datastore.save(account);
        System.out.println(account.toString());
        System.out.println("ok! Hooray!");
        return new AccountDTO(account);
    }

    public AccountDTO create(Account account) {
        if(datastore.find(Account.class).field("phoneNumber").equal(account.getPhoneNumber()).get() != null) {
            throw new ForbiddenException();
        }
        account.setToken(new ObjectId().toString());
        account.connect(true);
        datastore.save(account);
        System.out.println(account.toString());
        return new AccountDTO(account);
    }

    public void logOut(String phoneNumber){
        Account account = datastore.find(Account.class).field("phoneNumber").equal(phoneNumber).get();
        account.connect(false);
        datastore.save(account);
        System.out.println(account.toString());
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
        UpdateOperations<Account> setPosition = datastore.createUpdateOperations(Account.class).set("location", position);
        UpdateOperations<Account> setUpdate = datastore.createUpdateOperations(Account.class).set("updated", new Date());
        datastore.update(key, setPosition);
        datastore.update(key, setUpdate);
    }

    public void testInitDatabase() {
        datastore.getDB().dropDatabase();
        Account test = new Account("first", "last", "1234567890", "email@mail.com", "pwd");
        Account test1 = new Account("first1", "LAST1", "1234567890", "email@mail.com1", "pwd");
        Account test2 = new Account("first2", "last2", "1234567890", "email@mail.com2", "pwd");
        datastore.save(test);
        datastore.save(test1);
        datastore.save(test2);
    }

    /*public static void main(String[] args) {
        AccountDAO test = new AccountDAO();
//        test.testInitDatabase();
        test.updateLocation("59187c3c2f8b002154d905df",new Position(123.456,321.0));
//        System.out.println(test.findUserByName("first last"));

    }*/

    /*public static void main(String... args) {
            given()
                    .contentType("application/json")
                    .body("{" +
                            " \"phoneNumber\": \"0674942405\"," +
                            " \"firstName\": \"olivier\"," +
                            " \"lastName\": \"bob\"," +
                            " \"email\": \"olivier.pitton@kubity.com\"," +
                            " \"password\": \"salut\"" +
                            "}")
                    .log().all()
                    .post("http://52.232.34.116:8080/a/connect").then().log().all();
    }
*/

}
