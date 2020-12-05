package com.afilias.friendsrelationship.repositoy;


import com.afilias.friendsrelationship.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

}
