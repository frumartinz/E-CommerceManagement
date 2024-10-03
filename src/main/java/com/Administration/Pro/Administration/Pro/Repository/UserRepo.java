package com.Administration.Pro.Administration.Pro.Repository;

import com.Administration.Pro.Administration.Pro.Webdomains.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
