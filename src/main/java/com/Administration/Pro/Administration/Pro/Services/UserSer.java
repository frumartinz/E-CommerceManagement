package com.Administration.Pro.Administration.Pro.Services;

import com.Administration.Pro.Administration.Pro.Repository.UserRepo;
import com.Administration.Pro.Administration.Pro.Webdomains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSer {
    @Autowired
    public UserRepo userRepo;

    @Autowired private BCryptPasswordEncoder encoder;

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public long countUser(){
        long count = userRepo.count();
        return count;
    }
}
