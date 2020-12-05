package com.afilias.friendsrelationship.service;

import com.afilias.friendsrelationship.domain.UsersRest;

import java.util.List;

public interface FriendsService {

    List<UsersRest> findFriendsList(Long userId);

    List<UsersRest> findFriendOfFriendList(Long userId);

}
