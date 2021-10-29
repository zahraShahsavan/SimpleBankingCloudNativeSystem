package com.example.ui.controller;

import com.example.ui.model.Role;
import com.example.ui.model.User;
import com.example.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getalluser")
    public ModelAndView getAllUser(Pageable pageable, Model model){
        Page<User> page = userService.getAllUser(pageable);
        model.addAttribute("users",page.getContent());
        ModelAndView mav = new ModelAndView("showuser");
        return mav;
    }
    @PostMapping("/deluser")
    public void delUser(@RequestParam(name="id") long id, HttpServletResponse response) throws IOException {
        userService.delUserById(id);
        response.sendRedirect("/admin/getalluser");
    }
    @GetMapping("/adduser")
    public ModelAndView addUser(){
        ModelAndView mav = new ModelAndView("listOfCustomers");
        return mav;
    }
    @PostMapping("/adduser")
    public ModelAndView addUser(@RequestParam String username, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Set<Role> ms = new HashSet<>();
        Role r = new Role();
        r.setId(SignupController.Roles.ROLE_USER);
        r.setName(SignupController.Roles.ROLE_1);
        ms.add(r);
        user.setRoles(ms);

        userService.saveUser(user);

        ModelAndView mav = new ModelAndView("index");
        return mav;
    }


}
