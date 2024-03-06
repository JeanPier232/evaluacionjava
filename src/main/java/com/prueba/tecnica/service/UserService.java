/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba.tecnica.service;

import com.prueba.tecnica.commons.dto.UserDto;
import com.prueba.tecnica.exception.InvalidDataException;
import com.prueba.tecnica.model.User;
import java.util.List;

/**
 *
 * @author JeanPier
 */
public interface UserService {
    public User registerUser(UserDto user) throws InvalidDataException;
    public List<User> getAllUsers() throws InvalidDataException;
}
