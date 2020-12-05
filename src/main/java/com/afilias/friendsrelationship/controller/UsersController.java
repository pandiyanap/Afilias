package com.afilias.friendsrelationship.controller;


import com.afilias.friendsrelationship.domain.UsersRest;
import com.afilias.friendsrelationship.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UsersController {


    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<UsersRest>> getUsersList() {
        List<UsersRest> usersRests = userService.findUserList();
        return new ResponseEntity<>(usersRests, HttpStatus.OK);
    }


    @GetMapping("/geoFriendList")
    @ResponseBody
    public List<UsersRest> findGeoFriendList(@RequestParam @NotNull  String city, @RequestParam @NotNull Long userId) {
        List<UsersRest> usersRests = userService.findGeoFriendList(city, userId);

        return usersRests;
    }
}
