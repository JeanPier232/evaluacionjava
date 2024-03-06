/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.commons.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JeanPier
 */

@Getter
@Setter
public class PhoneDto {
    private String number;
    private String citycode;
    private String contrycode;
    public PhoneDto(String number, String citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }

    @Override
    public String toString() {
        return "PhoneDto{" + "number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode + '}';
    }
    
    
}
