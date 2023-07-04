package com.tx.cai.eureka.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaProviderController {
    @RequestMapping(value = "/provider/{name}", method = RequestMethod.GET)
    public String  test(@PathVariable String name){
        System.out.println("consumer"+name);
        return "consumer"+ name;

    }
}
