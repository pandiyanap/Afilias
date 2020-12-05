package com.afilias.friendsrelationship.controller;

import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsControllerTest {

    @Autowired
    private FriendsService friendsService;


    @GetMapping("/friendsList/{userId}")
    @ResponseBody
    public List<UsersRest> findFriendsList(@PathVariable Long userId) {

        List<UsersRest> friendsRests = friendsService.findFriendsList(userId);

        return friendsRests;
    }

    @GetMapping("/fofList/{userId}")
    @ResponseBody
    public List<UsersRest> findFriendOfFriendList(@PathVariable Long userId) {

        List<UsersRest> friendsRests = friendsService.findFriendOfFriendList(userId);

        return friendsRests;
    }


}
