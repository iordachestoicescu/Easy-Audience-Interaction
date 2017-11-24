package com.endava.easyaudienceinteraction.service;

import com.endava.easyaudienceinteraction.entity.User;
import com.endava.easyaudienceinteraction.exceptions.AdminNotFoundException;
import com.endava.easyaudienceinteraction.exceptions.WrongPasswordException;
import com.endava.easyaudienceinteraction.repository.UserRepository;
import com.endava.easyaudienceinteraction.util.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Laurentiu Iordache
 */
@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AtomicReference<String> login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new AdminNotFoundException();
        }

        String passHash = Crypt.cryptWithMD5(password);

        if (!user.getPassword().equals(passHash)) {
            throw new WrongPasswordException();
        }

        AtomicReference<String> response = new AtomicReference<>();
        response.set("Login successfully");

        return response;
    }
}
