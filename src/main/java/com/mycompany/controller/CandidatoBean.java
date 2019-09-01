/*
 * Clase para guardar los candidatos 
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

/**
 *
 * @author shhin
 */
@ManagedBean
@SessionScoped
public class CandidatoBean implements Serializable {

    /**
     * Varialbe para llamar al metodo que copia la imagen
     */
    private final CopyFile copyFile;
    
    /**
     * Lista para añadir a todos los candidatos
     */
    private static List<Candidato> listaCandidato;
    
    /**
     * Variable que llama al objeto candidato
     */
    private Candidato candidato;
    
    /**
     * Variable para tomar la ruta del archivo a subir
     */
    private UploadedFile uploadedFile;

    /**
     * Constructor para inicalizar la lista, candidato, y el metodo de copiar
     */
    public CandidatoBean() {
        candidato = new Candidato();
        copyFile = new CopyFile();
        listaCandidato = new ArrayList<>();
    }

    /**
     * Get para leer el objeto de candidato
     * @return 
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * Set  para guardar al candidato
     * @param candidato 
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    /**
     * Get para leer la ruta del archivo a subir
     * @return 
     */
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    /**
     * Set para guardar la ruta del archivo
     * @param uploadedFile 
     */
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    /**
     * Get para leer la lista de candidatos
     * @return 
     */
    public List<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    /**
     * Set para guardar la lista de candidatos
     * @param listaCandidato 
     */
    public void setListaCandidato(List<Candidato> listaCandidato) {
        CandidatoBean.listaCandidato = listaCandidato;
    }

    /**
     * Metodo que guarda la lista de candidatos y la foto
     */
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

    /**
     * Metodo que muestra la otra pagina
     * @return 
     */
    public String main() {
        return "mostrar?faces-redirect=true";
    }
}
