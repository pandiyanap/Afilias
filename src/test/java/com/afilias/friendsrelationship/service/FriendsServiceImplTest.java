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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FriendsServiceImplTest {

    @InjectMocks
    private FriendsServiceImpl friendsService;

    @Mock
    private UserRepository userRepository;


    @Test
    @DisplayName("Friends list exist")
    public void findFriendsList() {
        Users users = getDefaultUserList();
        List<Users> userList = Arrays.asList(users);
        given(userRepository.findFriendsList(any())).willReturn(userList);
        List<UsersRest> usersRests = friendsService.findFriendsList(1L);

        assertEquals(1, usersRests.size());

    }

    @Test
    @DisplayName("Friends list not exist")
    public void friendListNotExist() {
        given(userRepository.findFriendsList(any())).willReturn(Collections.emptyList());
        List<UsersRest> usersRests = friendsService.findFriendsList(1L);

        assertEquals(0, usersRests.size());

    }


    @Test
    @DisplayName("Find friend of friends")
    public void friendOfFriendExist() {
        Users users = getDefaultUserList();
        List<Users> userList = Arrays.asList(users);
        given(userRepository.findFriendOfFriendList(any())).willReturn(userList);
        List<UsersRest> usersRests = friendsService.findFriendOfFriendList(1L);

        assertEquals(1, usersRests.size());
    }

    @Test
    @DisplayName("Friend of friends not exists")
    public void FriendOfFriendNotExist() {
        given(userRepository.findFriendOfFriendList(any())).willReturn(Collections.emptyList());
        List<UsersRest> usersRests = friendsService.findFriendOfFriendList(1L);

        assertEquals(0, usersRests.size());
    }

}