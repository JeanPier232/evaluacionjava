/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.controllertests;

import com.prueba.tecnica.commons.dto.GenericoResponse;
import com.prueba.tecnica.commons.dto.PhoneDto;
import com.prueba.tecnica.commons.dto.UserDto;
import com.prueba.tecnica.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.prueba.tecnica.controller.UserController;
import com.prueba.tecnica.exception.InvalidDataException;
import static org.junit.jupiter.api.Assertions.*;
import com.prueba.tecnica.model.User;
import java.util.Collections;
import java.util.UUID;

/**
 *
 * @author JeanPier
 */
@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testRegisterUserSuccess() throws InvalidDataException {
        UserDto userDto = new UserDto();
        userDto.setName("Juan Rodriguez");
        userDto.setEmail("juan@rodriguez.cl");
        userDto.setPassword("hunter2");
        userDto.setPhones(Collections.singletonList(new PhoneDto("1234567", "1", "57")));
        User registeredUser = new User();
        registeredUser.setUserid(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        registeredUser.setName(userDto.getName());
        registeredUser.setEmail(userDto.getEmail());
        registeredUser.setPassword(userDto.getPassword());
        when(userService.registerUser(any(UserDto.class))).thenReturn(registeredUser);
        ResponseEntity<GenericoResponse<User>> responseEntity = userController.registerUser(userDto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Usuario registrado correctamente", responseEntity.getBody().getMessage());
        assertEquals(registeredUser, responseEntity.getBody().getData());
    }

    @Test
    public void testRegisterUserMissingFields() throws Exception {
        UserDto userDto = new UserDto();
        try {
            userService.registerUser(userDto);
        } catch (InvalidDataException e) {
            assertEquals("Faltan campos obligatorios en la solicitud: Nombre, Email, Password, Phones", e.getMessage());
        }
    }

    @Test
    public void testRegisterUserInvalidEmailFormat() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("Nombre");
        userDto.setEmail("correoinvalido");
        userDto.setPassword("password");
        userDto.setPhones(Collections.singletonList(new PhoneDto("1234567", "1", "57")));
        try {
            userService.registerUser(userDto);
        } catch (InvalidDataException e) {
            assertEquals("Formato de correo inválido", e.getMessage());
        }
    }

    @Test
    public void testRegisterUserInvalidData() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("");
        userDto.setEmail("");
        userDto.setPassword("");
        userDto.setPhones(Collections.emptyList());

        try {
            userService.registerUser(userDto);
        } catch (InvalidDataException e) {
            assertEquals("Faltan campos obligatorios en la solicitud: Nombre, Email, Password, Phones", e.getMessage());
        }
    }

    @Test
    public void testRegisterUserInternalServerError() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("Nombre");
        userDto.setEmail("nombre@outlook.cl");
        userDto.setPassword("password");
        List<PhoneDto> phones = new ArrayList<>();
        PhoneDto phoneDto = new PhoneDto("1234567", "1", "57");
        phones.add(phoneDto);
        userDto.setPhones(phones);
        when(userService.registerUser(any(UserDto.class))).thenThrow(new RuntimeException("Error interno del servidor"));
        ResponseEntity<GenericoResponse<User>> responseEntity = userController.registerUser(userDto);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody().getData());
        assertEquals("Error interno del servidor", responseEntity.getBody().getMessage());
        assertEquals(Integer.valueOf(500), responseEntity.getBody().getCodeStatus());
    }
}
