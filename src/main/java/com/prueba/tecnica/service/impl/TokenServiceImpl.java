/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.service.impl;

import com.prueba.tecnica.service.TokenService;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author JeanPier
 */

@Service
public class TokenServiceImpl implements TokenService{
    
    @Override
    public String generateToken() {
        UUID tokenUUID = UUID.randomUUID();
        return tokenUUID.toString();
    }
}
