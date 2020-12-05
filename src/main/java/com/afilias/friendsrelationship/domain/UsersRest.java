package com.afilias.friendsrelationship.domain;

import com.afilias.friendsrelationship.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersRest {

    private Long userId;
    private String name;
    private String city;


    public static UsersRest covertToDto(Users users) {
        UsersRest usersRest = new UsersRest();
        usersRest.setUserId(users.getUserId());
        usersRest.setCity(users.getCity());
        usersRest.setName(users.getName());

        return usersRest;

    }

}
