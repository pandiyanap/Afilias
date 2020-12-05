package com.afilias.friendsrelationship.service;


import com.afilias.friendsrelationship.domain.UsersRest;

import java.util.List;

public interface UserService {

    List<UsersRest> findUserList();

    List<UsersRest> findGeoFriendList(String city, Long userId);
}
