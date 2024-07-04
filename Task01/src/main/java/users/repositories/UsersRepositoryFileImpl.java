/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users.repositories;

/**
 *
 * @author ekaterina
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import users.models.User;


/**
 *
 * @author ekaterina
 */
public class UsersRepositoryFileImpl implements UsersRepository {
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(user.getId() + "|" + user.getName() + "|" + user.getEmail() + "|" + user.getPassword());
            writer.newLine();
        } catch (IOException e) { 
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String user;
            while((user = reader.readLine()) != null) {
                String[] userInfo = user.split("\\|");
                usersList.add(new User (userInfo[0], userInfo[1], userInfo[2], userInfo[3]));
            }
        }
        catch(IOException e) {
            throw new IllegalStateException(e);
        }
        return usersList;
    }

    @Override
    public void update(User user) {
        List<User> usersList = findAll();
        File usersFile = new File(fileName); 
        usersFile.delete();
        try {
            usersFile.createNewFile();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        for (User userFromList : usersList) {
            if (userFromList.getId().equals(user.getId())) {
                save(user);
            } else {
                save(userFromList);
            }
        }
    }
    
    @Override
    public void delete(String id) {
        List<User> usersList = findAll();
        File usersFile = new File(fileName); 
        usersFile.delete();
        try {
            usersFile.createNewFile();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        for (User user : usersList) {
            if (!user.getId().equals(id)) {
                save(user);
            }
        }
    }

    @Override
    public Optional<User> findById(String id) {
        User user = null;
        List<User> usersList = findAll();
        for (User userFromList : usersList) {
            if (userFromList.getId().equals(id)) {
                user = userFromList;
                break;
            }
        }       
        Optional<User> optionalUser = Optional.ofNullable(user);
        return optionalUser;
    }
}
