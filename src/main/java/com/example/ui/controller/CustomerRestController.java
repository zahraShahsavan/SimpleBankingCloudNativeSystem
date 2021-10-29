package com.example.ui.controller;

import com.example.ui.model.ECustomer;
import com.example.ui.model.EAccount;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/ui/customer")
@PreAuthorize("hasRole('ROLE_USER')")
public class CustomerRestController {

    @GetMapping("/add")
    public ModelAndView addCustomer(){
        ModelAndView modelAndView = new ModelAndView("addCustomer");
        return modelAndView;
    }


    @GetMapping("/deletebyid")
    public ModelAndView deleteCustomer(long id){
        ModelAndView modelAndView = new ModelAndView("deleteCustomer");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

//    @GetMapping("/deletebyid")
//    public void deleteCustomer(Long id){
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getForEntity("http://localhost:8081/customer/delete",null,id);
//    }


    @GetMapping("/list")
    public ModelAndView listOfAccounts() {
        ModelAndView modelAndView = new ModelAndView("listOfCustomers");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ECustomer>> response =
                restTemplate.exchange("http://localhost:8081/customer/getList",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ECustomer>>() {
                        });
        List<ECustomer> customerList = response.getBody();
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView editBook(){
        ModelAndView modelAndView = new ModelAndView("editCustomer");
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<ECustomer> customer =
//                restTemplate.getForEntity("http://localhost:8081/customer/get",ECustomer.class,id);
//        if (customer != null)
//            modelAndView.addObject("customer",customer.getBody());
//        else
//            modelAndView.addObject("customer",null);
        return modelAndView;
    }

}
