/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users.repositories;

import java.util.List;
import java.util.Optional;
import users.models.User;

/**
 *
 * @author ekaterina
 */
public interface UsersRepository {
    void save(User user);

    List<User> findAll();

    void update(User user);

    void delete(Integer id);

    Optional<User> findById(Integer id);
}
