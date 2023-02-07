package it.sincon.p2_presentazione_istanze_v2.Core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.sincon.p2_presentazione_istanze_v2.Services.dtos.UserDTO;
import it.sincon.p2_presentazione_istanze_v2.Services.services.UserService;

@RestController
public class TestController {
    
    @Autowired
    UserService userService;

    @GetMapping("/test")   //@RequestParam(value = "id", defaultValue = "1") 
    public UserDTO GetById(@PathVariable Integer id)
    {
        UserDTO userDTO = userService.GetById(1);
        return userDTO;
    }

}
