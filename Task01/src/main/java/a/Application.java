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
import users.repositories.UsersRepositoryFileImpl;
import users.services.UsersService;
import users.validators.SimpleValidator;
import users.validators.Validator;
/**
 *
 * @author ekaterina
 */
public class Application {
    
        public static void main(String[] args) {
        
        UsersRepository usersRepository = new UsersRepositoryFileImpl("/Users/ekaterina/Documents/users.txt");
        Validator validator = new SimpleValidator();
        UsersService usersService = new UsersService(usersRepository, validator);
        UsersUIConsole ui = new UsersUIConsole(usersService);
        ui.printRegistrationMenu();

        List<User> usersList = usersRepository.findAll();
        for (User user : usersList) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail() + " " + user.getPassword());
        }
        
        usersRepository.update(new User("ad9f4f41-5406-42da-bd58-e58ece275d10", "Q","@","1111111"));
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ekaterina/Documents/users.txt"))) {
            String user;
            while ((user = reader.readLine()) != null) {
                System.out.println(user);
            }
        }
        catch(IOException e) {
            throw new IllegalStateException();
        }
         
        usersRepository.delete("ad9f4f41-5406-42da-bd58-e58ece275d10");
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ekaterina/Documents/users.txt"))) {
            String user;
            while ((user = reader.readLine()) != null) {
                System.out.println(user);
            }
        }
        catch(IOException e) {
            throw new IllegalStateException();
        }
              
        //проверка для существующего пользователя      
        Optional<User> firstUser = usersRepository.findById("2cafff78-6164-4945-8049-ba27c5bad3f4");
        System.out.println(firstUser.toString());
        
        //для несуществующего
        Optional<User> secondUser = usersRepository.findById("f7e63dd-85d0-47ab-80e4-ec57c42e2886");
        System.out.println(secondUser.toString());        
        
    }
        
}

