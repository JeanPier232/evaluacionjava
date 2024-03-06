/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.repository;

import com.prueba.tecnica.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JeanPier
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    
}
