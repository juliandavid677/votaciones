/*
 * Clase pojo para crear la variables a utilizar
 */
package com.mycompany.dto;

import java.util.Date;

/**
 * @author Julián Parra 
 * @author Germán García
 */
public class Candidato {

    /**
     * Variable para guardar el nombre de la foto
     */
    private String foto;
    
    /**
     * Variable para guardar el nombre del candidato
     */
    private String nombre;
    
    /**
     * Variable para guarda su apellido
     */
    private String apellido;
    
    /**
     * Variable para guardar la fecha de nacimiento
     */
    private Date fechaNacimiento;
    
    /**
     * Variable para guarda la cedula del candidato
     */
    private Integer cedula;
    
    /**
     * Variable para guardar la descripción de la hoja de vida
     */
    private String hojaVida;
    
    /**
     * Variable para guardar el voto por cada candidato
     */
    private int voto;

    /**
     * Constructor para mostrar la tabla
     */
    public Candidato() {
    }

    /**
     * Constructor para guardar los datos resibidos 
     * @param foto
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param cedula
     * @param hojaVida 
     */
    public Candidato(String foto, String nombre, String apellido, Date fechaNacimiento, Integer cedula, String hojaVida) {
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.hojaVida = hojaVida;
    }

    /**
     * Get para leer la foto
     * @return foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Set para guardar la foto
     * @param foto 
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Get para leer el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set para guardar el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get para leer el apellido
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set para guardar el apellido
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Get para leer la fecha de nacimiento
     * @return fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Set para guardar la fecha de nacimiento
     * @param fechaNacimiento 
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Get para leer la cedula
     * @return cedula
     */
    public Integer getCedula() {
        return cedula;
    }

    /**
     * Set para guardar la cedula
     * @param cedula 
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    /**
     * Get para leer la descripción de la hoja de vida
     * @return 
     */
    public String getHojaVida() {
        return hojaVida;
    }

    /**
     * Set para guardar la descripción de la hoja de vida
     * @param hojaVida 
     */
    public void setHojaVida(String hojaVida) {
        this.hojaVida = hojaVida;
    }

    /**
     * Get para leer el voto
     * @return 
     */
    public int getVoto() {
        return voto;
    }

    /**
     * Set para guardar el voto
     * @param voto 
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

}
