package com.endava.easyaudienceinteraction.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Laurentiu Iordache
 */
@Service
public interface LoginService {
    AtomicReference<String> login(String username, String password);
}
