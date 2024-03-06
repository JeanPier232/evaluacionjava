/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.service;

import com.prueba.tecnica.exception.InvalidDataException;
import com.prueba.tecnica.model.Phone;
import java.util.List;

/**
 *
 * @author JeanPier
 */
public interface PhoneService {
    public List<Phone> getAllPhones() throws InvalidDataException;
}
