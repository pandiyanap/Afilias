package com.afilias.friendsrelationship.service;


import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.entity.Users;
import com.afilias.friendsrelationship.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UsersRest> findUserList() {
        List<Users> users = userRepository.findAll();
        List<UsersRest> usersRests = new ArrayList<>();
        users.forEach(user -> usersRests.add(UsersRest.covertToDto(user)));

        return usersRests;
    }


    @Override
    public List<UsersRest> findGeoFriendList(String city, Long userId) {

        List<Users> users = userRepository.findByCityAndUserIdNot(city, userId);
        List<UsersRest> usersRests = new ArrayList<>();
        users.stream().filter(Objects::nonNull).forEach(user -> usersRests.add(UsersRest.covertToDto(user)));

        return usersRests;
    }

}
