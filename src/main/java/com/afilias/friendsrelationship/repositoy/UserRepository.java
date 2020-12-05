package com.afilias.friendsrelationship.repositoy;


import com.afilias.friendsrelationship.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Long> {

    @Transactional(readOnly = true)
    List<Users> findByCityAndUserIdNot(String city, Long userId);

    @Query(value = "select\n" +
            "   * \n" +
            "from\n" +
            "   user_details \n" +
            "where\n" +
            "   user_id in\n" +
            "   (\n" +
            "      select\n" +
            "         fr.friend_id \n" +
            "      from\n" +
            "         friends_relationship fr \n" +
            "      where\n" +
            "         fr.user_id = :userId\n" +
            "   )\n" , nativeQuery = true)
    @Transactional(readOnly = true)
    List<Users> findFriendsList(Long userId);


    @Query(value = "select\n" +
            "   * \n" +
            "from\n" +
            "   user_details ud \n" +
            "where\n" +
            "   ud.user_id in \n" +
            "   (\n" +
            "      Select distinct\n" +
            "(fr1.user_id) \n" +
            "      from\n" +
            "         friends_relationship fr1 \n" +
            "      where\n" +
            "         fr1.friend_id in\n" +
            "         (\n" +
            "            select\n" +
            "               fr.friend_id \n" +
            "            from\n" +
            "               friends_relationship fr \n" +
            "            where\n" +
            "               fr.user_id = :userId\n" +
            "         )\n" +
            "   )\n" +
            "   and ud.user_id != :userId ", nativeQuery = true)
    @Transactional(readOnly = true)
    List<Users> findFriendOfFriendList(Long userId);

}
