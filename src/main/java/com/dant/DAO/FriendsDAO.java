package com.dant.dao;

import com.dant.entity.Account;
import com.dant.entity.Friends;
import com.dant.entity.dto.AccountDTO;
import com.dant.entity.dto.FriendsDTO;
import org.mongodb.morphia.Datastore;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyen on 30/05/2017.
 */
public class FriendsDAO {
    private final Datastore datastore = DatastoreInit.getDatastore();

    public FriendsDTO addContact(String number1, String number2){
        if (testFriendShip(number1, number2) == true){
            throw new ForbiddenException();
        }
        Friends friends = new Friends(number1, number2);
        datastore.save(friends);
        System.out.println(friends.toString());
        return new FriendsDTO(friends);
    }

    public boolean testFriendShip(String num1, String num2){
        boolean areFriends = false;
        for(Friends friends : datastore.find(Friends.class).field("number1").equal(num1).asList()) {
            areFriends = (friends.getAccount2().equals(num2));
        }
        for(Friends friends : datastore.find(Friends.class).field("number2").equal(num1).asList()) {
            areFriends = areFriends||(friends.getAccount1().equals(num2));
        }
        return areFriends;
    }

    public Friends accept(String number1, String number2, boolean accept){
        Friends friends = datastore.find(Friends.class)
                .field("number1").equal(number1)
                .field("number2").equal(number2)
                .get();
        if(friends == null)
            friends = datastore.find(Friends.class)
                    .field("number1").equal(number2)
                    .field("number2").equal(number1)
                    .get();
        if(friends == null){
            System.out.println();
            throw new NotFoundException();
        }
        else {
            friends.accept(accept);
            datastore.save(friends);
            System.out.println(friends.toString());
        }
        return friends;
    }

    public List<AccountDTO> getFriends(String number){
        List<AccountDTO> friendsList = new ArrayList<>();
        for(Friends friends : datastore.find(Friends.class).field("number1").equal(number).asList()) {
            if (friends.isAccepted()) {
                Account friend = datastore.find(Account.class).field("phoneNumber").equal(friends.getAccount2()).get();
                friendsList.add(new AccountDTO(friend));
                System.out.println(friends.getAccount2());
            }
        }
        for(Friends friends : datastore.find(Friends.class).field("number2").equal(number).asList()) {
            if (friends.isAccepted()) {
                Account friend = datastore.find(Account.class).field("phoneNumber").equal(friends.getAccount1()).get();
                friendsList.add(new AccountDTO(friend));
                System.out.println(friends.getAccount1());
            }
        }
        System.out.println(friendsList.size() +" friends");
        return friendsList;
    }
}
