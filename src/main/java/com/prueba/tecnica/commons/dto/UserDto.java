/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.commons.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JeanPier
 */

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String password;
    private List<PhoneDto> phones;

    @Override
    public String toString() {
        return "UserDto{" + "name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + '}';
    }
    
}
