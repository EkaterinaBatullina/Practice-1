/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import users.controllers.UsersUIConsole;
import users.models.User;
import users.repositories.UsersRepository;
import users.repositories.UsersRepositoryJdbcImpl;
import users.services.UsersService;
import users.validators.SimpleValidator;
import users.validators.Validator;
import util.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 *
 * @author ekaterina
 */
public class Application {
    
    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource("org.postgresql.Driver",
                    "jdbc:postgresql://localhost:5432/javalab_2024_db", "postgres", "eka_rina16");
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        Validator validator = new SimpleValidator();
        UsersService usersService = new UsersService(usersRepository, validator);
        UsersUIConsole ui = new UsersUIConsole(usersService);
        ui.printRegistrationMenu();
    }

}

