package com.afilias.friendsrelationship.service;


import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.entity.Users;
import com.afilias.friendsrelationship.repositoy.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.afilias.friendsrelationship.utils.getDefaultUserList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;


    @Test
    @DisplayName("User List exist")
    public void findUserList() {
        Users users = getDefaultUserList();
        List<Users> userList = Arrays.asList(users);
        given(userRepository.findAll()).willReturn(userList);
        List<UsersRest> usersRests = userService.findUserList();

        assertEquals(1, usersRests.size());

    }

    @Test
    @DisplayName("User List Not exist")
    public void userListNotExist() {
        given(userRepository.findAll()).willReturn(Collections.emptyList());
        List<UsersRest> usersRests = userService.findUserList();

        assertEquals(0, usersRests.size());

    }


    @Test
    @DisplayName("Find friend by geo location")
    public void findFriendsByGeo() {
        Users users = getDefaultUserList();
        List<Users> userList = Arrays.asList(users);
        given(userRepository.findByCityAndUserIdNot(any(),any())).willReturn(userList);
        List<UsersRest> usersRests = userService.findGeoFriendList(users.getCity(),users.getUserId());

        assertEquals(1,usersRests.size());
        assertEquals("Dublin", usersRests.get(0).getCity());
    }

    @Test
    @DisplayName("Find friend by invalid geo location")
    public void findFriendsByInvalidGeo() {
        Users users = getDefaultUserList();
        List<Users> userList = Arrays.asList(users);
        given(userRepository.findByCityAndUserIdNot(any(),any())).willReturn(userList);
        List<UsersRest> usersRests = userService.findGeoFriendList(users.getCity(),users.getUserId());

        assertEquals(1,usersRests.size());
        assertNotEquals("Galway", usersRests.get(0).getCity());
    }

}
