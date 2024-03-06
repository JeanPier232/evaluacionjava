/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JeanPier
 */

@Getter
@Setter
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String number;
    private String citycode;
    private String contrycode;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;
    
    public Phone(String number, String citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }
    
    public Phone() {
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode + '}';
    }
}
