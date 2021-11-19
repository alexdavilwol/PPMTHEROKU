package com.alex.ppmtool.services;

import com.alex.ppmtool.domain.User;
import com.alex.ppmtool.exceptions.UsernameAlreadyExistsException;
import com.alex.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //this class allows you to encode the password so that we don't store them as simple strings
    //cant just autowire it because it is not a bean
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());
            //Make sure the password and confirm password match
            //We do not persist or show confirmPassword
            newUser.setConfirmPassword("");

            return userRepository.save(newUser);
        }catch(Exception e){
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists.");

        }

    }

}
