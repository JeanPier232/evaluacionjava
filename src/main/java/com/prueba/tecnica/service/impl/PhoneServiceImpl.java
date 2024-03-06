/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.service.impl;

import com.prueba.tecnica.exception.InvalidDataException;
import com.prueba.tecnica.service.PhoneService;
import java.util.List;
import org.springframework.stereotype.Service;
import com.prueba.tecnica.model.Phone;
import com.prueba.tecnica.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author JeanPier
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAllPhones() throws InvalidDataException {
        List<Phone> phones = phoneRepository.findAll();
        return phones;
    }
}
