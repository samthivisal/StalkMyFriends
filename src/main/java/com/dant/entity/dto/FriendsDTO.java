package com.dant.entity.dto;

import com.dant.entity.Account;
import com.dant.entity.Friends;
import com.google.gson.annotations.Expose;
import org.mongodb.morphia.annotations.Reference;

/**
 * Created by nguyen on 30/05/2017.
 */
public class FriendsDTO {
    @Reference
    private Account account1;

    @Reference
    private Account account2;

    @Expose
    private boolean accepted;

    public FriendsDTO(Friends friends){
        account1 = friends.getAccount1();
        account2 = friends.getAccount2();
        accepted = friends.isAccepted();
    }
}
