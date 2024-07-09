/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package users.validators;

/**
 *
 * @author ekaterina
 */
public interface Validator {
    
    void validateEmail(String email) throws IllegalArgumentException;
    
    void validateName(String email) throws IllegalArgumentException;
    
    void validatePassword(String email) throws IllegalArgumentException;
    
}
