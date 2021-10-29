package com.example.ui.controller;

import com.example.ui.dto.response.DefaultResponse;
import com.example.ui.model.EAccount;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/ui/account")
@PreAuthorize("hasRole('ROLE_USER')")
public class AccountRestController {


    @GetMapping("/add")
    public ModelAndView addAccount(){
        ModelAndView modelAndView = new ModelAndView("addAccount");
        return modelAndView;
    }


    @GetMapping("/deletebyid")
    public ModelAndView deleteAccount(long id){
        ModelAndView modelAndView = new ModelAndView("deleteAccount");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

//    @GetMapping("/deletebyid")
//    public void deleteAccount(long id){
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getForEntity("http://localhost:8081/account/delete", DefaultResponse.class,id);
//    }


    @GetMapping("/list")
    public ModelAndView listOfAccounts() {
        ModelAndView modelAndView = new ModelAndView("listOfAccounts");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<EAccount>> response =
                restTemplate.exchange("http://localhost:8081/account/getList",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<EAccount>>() {
                        });
        List<EAccount> accountList = response.getBody();
        modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView editAccount(){
        ModelAndView modelAndView = new ModelAndView("editAccount");
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<EAccount> account =
//                restTemplate.getForEntity("http://localhost:8081/account/get",EAccount.class,id);
//        if (account != null)
//            modelAndView.addObject("account",account.getBody());
//        else
//            modelAndView.addObject("account",null);
        return modelAndView;
    }

}
