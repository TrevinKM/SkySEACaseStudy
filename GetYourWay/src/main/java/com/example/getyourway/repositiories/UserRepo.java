package com.example.getyourway.repositiories;

import com.example.getyourway.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmailAddress(String emailAddress);
    public Optional<User> findUserByEmailAddress(String emailAddress);

}
