package com.afilias.friendsrelationship.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends_relationship")
@Getter
@Setter
@NoArgsConstructor
public class Friends {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "friends_type")
    private String friendsType;

    @Column(name = "friend_id")
    private Long friendId;


}
