package com.application.repositories;

import com.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT u FROM users u where u.userId= ?1")
    User findByUserId(String id);
    @Query("SELECT u FROM users u where u.email= ?1")
    User findUserByEmail(String email);


}
