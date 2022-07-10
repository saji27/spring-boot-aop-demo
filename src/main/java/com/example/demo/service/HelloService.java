package com.example.demo.service;

import com.example.demo.annotation.Timed;
import org.springframework.stereotype.Service;


@Service
public class HelloService {

    @Timed
    public String sayHello(){
        return "Hello !! How are you ? ".concat(HelloService.offerHelp());
    }

    @Timed
    public static String offerHelp(){
        return "How can i help you ? " + System.currentTimeMillis();
    }

}
