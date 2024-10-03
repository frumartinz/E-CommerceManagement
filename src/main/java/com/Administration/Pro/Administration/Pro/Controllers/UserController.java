package com.Administration.Pro.Administration.Pro.Controllers;

import com.Administration.Pro.Administration.Pro.Repository.RoleRepository;
import com.Administration.Pro.Administration.Pro.Services.UserSer;
import com.Administration.Pro.Administration.Pro.Webdomains.Role;
import com.Administration.Pro.Administration.Pro.Webdomains.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.management.relation.Role;
import java.util.List;

@Controller
public class UserController {

    public static String  uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/userImages";
    @Autowired
    public UserSer userSer;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login() {
        return "index-2";
    }

    @GetMapping("/user/register")
    public String registerNewUser(Model trans){
        User newUser = new User();
        List<Role> roles = roleRepository.findAll();
        trans.addAttribute("roles", roles);
        trans.addAttribute("newUser", newUser);
        return "signUp";
    }

    @PostMapping("/user/registration")
    public String showUserRegistrationPage(User user) {
        userSer.saveUser(user);
        return "redirect:/login";
    }

}
