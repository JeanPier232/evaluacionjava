/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.util;

import com.prueba.tecnica.commons.dto.PhoneDto;
import com.prueba.tecnica.commons.dto.UserDto;
import com.prueba.tecnica.exception.InvalidDataException;
import com.prueba.tecnica.model.Phone;
import com.prueba.tecnica.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author JeanPier
 */
public class UserUtil {

    public static User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        List<Phone> phones = new ArrayList<>();
        for (PhoneDto phoneDto : userDto.getPhones()) {
            Phone phone = new Phone(phoneDto.getNumber(), phoneDto.getCitycode(), phoneDto.getContrycode());
            phone.setUser(user);
            phones.add(phone);
        }
        user.setPhones(phones);
        return user;
    }

    public static List<String> verificarCamposFaltantes(UserDto userDto) {
        List<String> camposFaltantes = new ArrayList<>();
        if (userDto.getName() == null || StringUtils.isEmpty(userDto.getName())) {
            camposFaltantes.add("Nombre");
        }
        if (userDto.getEmail() == null || StringUtils.isEmpty(userDto.getEmail())) {
            camposFaltantes.add("Email");
        }
        if (userDto.getPassword() == null || StringUtils.isEmpty(userDto.getPassword())) {
            camposFaltantes.add("Password");
        }
        if (userDto.getPhones() == null || userDto.getPhones().isEmpty()) {
            camposFaltantes.add("Phones");
        }
        return camposFaltantes;
    }

    public static void validateEmail(String email) throws InvalidDataException {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.cl$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new InvalidDataException("Formato de correo inválido");
        }
    }
}
