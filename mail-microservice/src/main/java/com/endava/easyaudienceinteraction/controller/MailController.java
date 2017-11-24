package com.endava.easyaudienceinteraction.controller;

import com.endava.easyaudienceinteraction.dto.MailRequest;
import com.endava.easyaudienceinteraction.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Laurentiu Iordache
 */
@Controller
@RequestMapping("/mail")
@CrossOrigin(origins = "http://localhost:9090")
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping(value = "/send",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    public void sendMail(@RequestBody MailRequest mailRequest) {
        mailService.sendMail(mailRequest);
    }


}
