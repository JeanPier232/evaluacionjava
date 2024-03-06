/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.controller;

import com.prueba.tecnica.commons.dto.GenericoResponse;
import com.prueba.tecnica.commons.dto.UserDto;
import com.prueba.tecnica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.prueba.tecnica.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.tecnica.exception.InvalidDataException;
import com.prueba.tecnica.model.Phone;
import com.prueba.tecnica.service.PhoneService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author JeanPier
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/register-user")
    public ResponseEntity<GenericoResponse<User>> registerUser(@RequestBody(required = false) UserDto userDto) {
        if (userDto == null) {
            GenericoResponse<User> response = new GenericoResponse<>(400, "El cuerpo de la solicitud está vacío", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            logger.info("Inicio registerUser controller");
            User registeredUser = userService.registerUser(userDto);
            GenericoResponse<User> response = new GenericoResponse<>(200, "Usuario registrado correctamente", registeredUser);
            logger.info("Fin registerUser controller");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidDataException e) {
            logger.error("Datos de usuario inválidos: {}", e.getMessage(), e);
            GenericoResponse<User> response = new GenericoResponse<>(400, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Error interno del servidor: {}", e.getMessage(), e);
            GenericoResponse<User> response = new GenericoResponse<>(500, "Error interno del servidor", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-users")
    public ResponseEntity<GenericoResponse<List<User>>> listUsers() {
        try {
            List<User> userList = userService.getAllUsers();
            GenericoResponse<List<User>> response = new GenericoResponse<>(200, "Lista de usuarios recuperada correctamente", userList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidDataException e) {
            logger.error("Error al recuperar la lista de usuarios: {}", e.getMessage(), e);
            GenericoResponse<List<User>> response = new GenericoResponse<>(500, "Error interno del servidor al recuperar la lista de usuarios", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-phones")
    public ResponseEntity<GenericoResponse<List<Phone>>> listPhones() {
        try {
            List<Phone> phoneList = phoneService.getAllPhones();
            System.out.println("phoneList: " + phoneList);
            GenericoResponse<List<Phone>> response = new GenericoResponse<>(200, "Lista de teléfonos recuperada correctamente", phoneList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidDataException e) {
            logger.error("Error al recuperar la lista de teléfonos: {}", e.getMessage(), e);
            GenericoResponse<List<Phone>> response = new GenericoResponse<>(500, "Error interno del servidor al recuperar la lista de teléfonos", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
