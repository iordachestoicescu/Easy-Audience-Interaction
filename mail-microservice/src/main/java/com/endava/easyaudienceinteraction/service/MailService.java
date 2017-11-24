package com.endava.easyaudienceinteraction.service;

import com.endava.easyaudienceinteraction.dto.MailRequest;
import org.springframework.stereotype.Service;

/**
 * @author Laurentiu Iordache
 */

@Service
public interface MailService {
    void init(String username, String password);

    void sendMail(MailRequest mailRequest);
}
