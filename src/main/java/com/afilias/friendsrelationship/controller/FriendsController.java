package com.afilias.friendsrelationship.controller;

import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.service.FriendsService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin(origins = "http://localhost:3000")
public class FriendsController {

    @Autowired
    private FriendsService friendsService;


    @GetMapping("/{userId}")
    @ResponseBody
    public List<UsersRest> findFriendsList(@PathVariable @NotNull Long userId) {

        List<UsersRest> friendsRests = friendsService.findFriendsList(userId);

        return friendsRests;
    }

    @GetMapping("/fofList/{userId}")
    @ResponseBody
    public List<UsersRest> findFriendOfFriendList(@PathVariable @NotNull Long userId) {

        List<UsersRest> friendsRests = friendsService.findFriendOfFriendList(userId);

        return friendsRests;
    }


}
