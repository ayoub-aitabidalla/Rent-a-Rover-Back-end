package com.application.services;

import com.application.entities.User;
import com.application.repositories.UserRepository;
import com.application.shareds.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    public void createUser(User user)
    {
        User checkuser=userRepository.findUserByEmail(user.getEmail());
        if(checkuser != null)
        {
            throw new RuntimeException("user already exist");
        }
        user.setUserId(utils.generateStringId(10));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public User getUserByUserId(String userId)
    {
        return userRepository.findByUserId(userId);
    }
    public void deleteUser(String id)
    {
        User user = userRepository.findByUserId(id);
        if(user == null)
        {
            throw new RuntimeException("user doesn't exist");
        }
        userRepository.delete(user);
    }
    public User updateUser(String id, User user)
    {
        User userToUpdate = userRepository.findByUserId(id);
        if(userToUpdate == null)
        {
            throw new RuntimeException("user doesn't exist");
        }
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setMobile(user.getMobile());
        return userRepository.save(userToUpdate);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if(user == null) throw new UsernameNotFoundException(email);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>());

    }
    public User getUser(String email)
    {
        User user = userRepository.findUserByEmail(email);
        if(user == null)
        {
            throw new RuntimeException("user doesn't exist");
        }
        return user;
    }
}

