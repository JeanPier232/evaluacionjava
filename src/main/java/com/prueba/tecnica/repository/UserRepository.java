/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.tecnica.model.User;
import java.util.Optional;

/**
 *
 * @author JeanPier
 */
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByEmail(String email);
}
