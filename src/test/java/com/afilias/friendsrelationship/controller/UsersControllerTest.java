package com.afilias.friendsrelationship.controller;


import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsersControllerTest {


    @Autowired
    private UserService userService;


    @GetMapping("/users")
    @ResponseBody
    public List<UsersRest> getUsersList() {
        List<UsersRest> usersRests = userService.findUserList();
        return usersRests;
    }


    @GetMapping("/geoFriendList")
    @ResponseBody
    public List<UsersRest> findGeoFriendList(@RequestParam String city, @RequestParam Long userId) {
        List<UsersRest> usersRests =userService.findGeoFriendList(city, userId);

        return usersRests;
    }
}
