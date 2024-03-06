/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tecnica.commons.dto;

/**
 *
 * @author JeanPier
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericoResponse<T> {
    private T data;
    private String message;
    private Integer codeStatus;
    
    public GenericoResponse() {
    }

    public GenericoResponse(Integer codeStatus, String message, T data) {
        this.codeStatus = codeStatus;
        this.message = message;
        this.data = data;
    }
}
