package com.afilias.friendsrelationship;

import com.afilias.friendsrelationship.entity.Users;

public class utils {


    public static Users getDefaultUserList() {
        Users users = new Users();
        users.setUserId(1L);
        users.setCity("Dublin");
        users.setName("TestUser1");

        return users;
    }
}
