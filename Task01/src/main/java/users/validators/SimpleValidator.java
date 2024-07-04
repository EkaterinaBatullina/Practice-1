/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users.validators;

/**
 *
 * @author ekaterina
 */
public class SimpleValidator implements Validator {

    @Override
    public void validateEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Incorrect email");
        }
    }
    
    @Override
    public void validateName(String name) {
        if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Incorrect name");
        }
    }

    @Override
    public void validatePassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Incorrect password");
        }
    }    
}
