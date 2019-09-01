/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.Candidato;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import com.mycompany.model.CopyFile;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author shhin
 */
@ManagedBean
@SessionScoped
public class CandidatoBean implements Serializable {

    private final CopyFile copyFile;
    private static List<Candidato> listaCandidato;
    private Candidato candidato;
    private UploadedFile uploadedFile;

    public CandidatoBean() {
        candidato = new Candidato();
        copyFile = new CopyFile();
        listaCandidato = new ArrayList<>();
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public List<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    public void setListaCandidato(List<Candidato> listaCandidato) {
        CandidatoBean.listaCandidato = listaCandidato;
    }

    public void saveMessage() {
        String nombreFoto = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            File file = new File(uploadedFile.getFileName());
            System.out.println(file);
            nombreFoto = copyFile.copyFile(file.getName(), this.uploadedFile.getInputstream());
            FacesMessage message = new FacesMessage(
                    "El archivo se ha subido con éxito!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            listaCandidato.add(new Candidato(nombreFoto, this.candidato.getNombre(), this.candidato.getApellido(),
                    this.candidato.getFechaNacimiento(), this.candidato.getCedula(), this.candidato.getHojaVida()));

        } catch (IOException e) {
            System.out.println("ERROR");
        }
        context.addMessage(null, new FacesMessage("Successful", "Your message: " + this.candidato.getNombre()));

    }

    public String main() {
        return "mostrar?faces-redirect=true";
    }

}
