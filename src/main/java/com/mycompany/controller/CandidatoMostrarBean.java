/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.Candidato;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author shhin
 */
@ManagedBean
@RequestScoped
public class CandidatoMostrarBean implements Serializable {

    private PieChartModel pieModel1;
    private Candidato selectCandidato;
    @ManagedProperty("#{candidatoBean}")
    private CandidatoBean candidato;

    /**
     * Creates a new instance of CandidatoMostrarBean
     */
    public CandidatoMostrarBean() {
        pieModel1 = new PieChartModel();
    }

    public CandidatoBean getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoBean candidato) {
        this.candidato = candidato;
    }

    public PieChartModel getPieModel1() {
        for (Candidato listaCandidato1 : this.candidato.getListaCandidato()) {
            System.out.println(listaCandidato1.getNombre() + "  NOMBRE DE LA LISTA");
            pieModel1.set(listaCandidato1.getNombre(), listaCandidato1.getVoto());
        }
        pieModel1.setTitle("Votos");
        pieModel1.setLegendPosition("e");
        pieModel1.setShadow(false);
        return pieModel1;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    public Candidato getSelectCandidato() {
        return selectCandidato;
    }

    public void setSelectCandidato(Candidato selectCandidato) {
        this.selectCandidato = selectCandidato;
        System.out.println("ENTRO AL SET " + selectCandidato.getNombre());
        try {
            for (Candidato listaCandidato1 : this.candidato.getListaCandidato()) {
                if (Objects.equals(selectCandidato.getCedula(), listaCandidato1.getCedula())) {
                    System.out.println("ENTRO AL IF");
                    int voto = listaCandidato1.getVoto();
                    listaCandidato1.setVoto(voto + 1);
                    System.out.println(listaCandidato1.getVoto() + "  LISTA DE VOTOS ");
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR VOTOS");
        }

    }
    
    public void onRowSelect(SelectEvent event) {
        Candidato e = ((Candidato) event.getObject());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Your message: " + e.getNombre()));
    }
}
