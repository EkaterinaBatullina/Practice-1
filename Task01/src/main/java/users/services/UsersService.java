/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users.services;

import java.util.UUID;
import users.models.User;
import users.repositories.UsersRepository;
import users.validators.Validator;

/**
 *
 * @author ekaterina
 */
public class UsersService {

    private final Validator validator;

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository, Validator validator) {
        this.validator = validator;
        this.usersRepository = usersRepository;
    }

    public void register(String name, String email, String password) {
       
        validator.validateEmail(email);
        validator.validateName(name);
        validator.validatePassword(password);
        
        User user = new User(UUID.randomUUID().toString(), name, email, password);

        usersRepository.save(user);
    }
}
