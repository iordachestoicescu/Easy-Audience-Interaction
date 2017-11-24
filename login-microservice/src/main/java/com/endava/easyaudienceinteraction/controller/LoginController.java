package com.endava.easyaudienceinteraction.controller;

import com.endava.easyaudienceinteraction.dto.LoginRequest;
import com.endava.easyaudienceinteraction.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Laurentiu Iordache
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/admin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    public AtomicReference<String> login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @RequestMapping(value = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "test";
    }
}
