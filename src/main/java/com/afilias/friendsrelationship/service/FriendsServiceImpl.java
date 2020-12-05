package com.afilias.friendsrelationship.service;

import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.entity.Users;
import com.afilias.friendsrelationship.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UsersRest> findFriendsList(Long userId) {
        List<Users> users = userRepository.findFriendsList(userId);
        List<UsersRest> usersRests = new ArrayList<UsersRest>();
        users.forEach(user -> usersRests.add(UsersRest.covertToDto(user)));

        return usersRests;
    }

    @Override
    public List<UsersRest> findFriendOfFriendList(Long userId) {
        List<Users> users = userRepository.findFriendOfFriendList(userId);
        List<UsersRest> usersRests = new ArrayList<UsersRest>();
        users.forEach(user -> usersRests.add(UsersRest.covertToDto(user)));

        return usersRests;
    }


}
