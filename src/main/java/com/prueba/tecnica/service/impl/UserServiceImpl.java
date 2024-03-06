/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.service.impl;

import com.prueba.tecnica.commons.dto.UserDto;
import com.prueba.tecnica.exception.InvalidDataException;
import com.prueba.tecnica.model.User;
import com.prueba.tecnica.repository.UserRepository;
import com.prueba.tecnica.service.UserService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.tecnica.service.TokenService;
import com.prueba.tecnica.util.UserUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author JeanPier
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public User registerUser(UserDto userDto) throws InvalidDataException {

        logger.info("Inicio registerUser serviceimpl");

        List<String> camposFaltantes = UserUtil.verificarCamposFaltantes(userDto);

        if (!camposFaltantes.isEmpty()) {
            throw new InvalidDataException("Faltan campos obligatorios en la solicitud: " + String.join(", ", camposFaltantes));
        }
        UserUtil.validateEmail(userDto.getEmail());
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new InvalidDataException("El correo " + userDto.getEmail() + " ya está registrado");
        }

        User user = UserUtil.convertToEntity(userDto);

        LocalDateTime now = LocalDateTime.now();
        user.setCreated(now);
        user.setModified(now);
        user.setActive(true);
        String token = tokenService.generateToken();
        System.out.println("Token generado: " + token);
        user.setToken(token);
        user.setLastLogin(LocalDateTime.now());

        System.out.println("user: " + user);
        User savedUser = userRepository.save(user);
        logger.info("Fin registerUser serviceimpl: {}", savedUser.getName());
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() throws InvalidDataException {
        try {
            List<User> users = userRepository.findAll();
            for (User user : users) {
                if (user.getPhones() == null) {
                    user.setPhones(new ArrayList<>());
                }
                System.out.println("Teléfonos de " + user.getName() + ": " + user.getPhones());
                user.getPhones().size();
            }
            return users;
        } catch (Exception e) {
            throw new InvalidDataException("Error al recuperar la lista de usuarios");
        }
    }
}
