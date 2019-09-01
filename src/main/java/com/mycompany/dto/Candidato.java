/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author shhin
 */
public class Candidato {

    @NotNull(message = "DEBE CONTENER UN ARCHIVO DE IMAGEN")
    private String foto;
    
    private String nombre;
    
    private String apellido;
    
    private Date fechaNacimiento;
    
    private Integer cedula;
    
    private String hojaVida;
    
    private int voto;

    public Candidato() {
    }

    public Candidato(String foto, String nombre, String apellido, Date fechaNacimiento, Integer cedula, String hojaVida) {
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.hojaVida = hojaVida;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getHojaVida() {
        return hojaVida;
    }

    public void setHojaVida(String hojaVida) {
        this.hojaVida = hojaVida;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

}
