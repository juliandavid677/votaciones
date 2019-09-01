/*
 * Clase que muestra los candidatos y la grafica
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
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 * @author Julián Parra 
 * @author Germán García
 */
@ManagedBean
@RequestScoped
public class CandidatoMostrarBean implements Serializable {

    /**
     * Variable que carga el modelo de las estadisticas
     */
    private PieChartModel pieModel1;

    /**
     * Variable que selecciona al candidato
     */
    private Candidato selectCandidato;

    /**
     * ManagedProperty que llama al otro bean del index
     */
    @ManagedProperty("#{candidatoBean}")

    /**
     * Donde se guarda el llamado al ManagedBean
     */
    private CandidatoBean candidato;

    /**
     * Constructor que inicia el modelo para la grafica
     */
    public CandidatoMostrarBean() {
        pieModel1 = new PieChartModel();
    }

    /**
     * Get para leer al ManagedBean del index
     *
     * @return candidato
     */
    public CandidatoBean getCandidato() {
        return candidato;
    }

    /**
     * Set para guardar al ManagedBean del index
     *
     * @param candidato
     */
    public void setCandidato(CandidatoBean candidato) {
        this.candidato = candidato;
    }

    /**
     * Metodo par cargar el modelo de la grafica
     *
     * @return pieModel1
     */
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

    /**
     * Set para guardar el modelo
     *
     * @param pieModel1
     */
    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    /**
     * Get para leer al candidato seleccionado
     *
     * @return
     */
    public Candidato getSelectCandidato() {
        return selectCandidato;
    }

    /**
     * Set para guardar al candidato seleccionado y sumarle los votos
     *
     * @param selectCandidato
     */
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

    /**
     * Para seleccionar al candidato
     * @param event 
     */
    public void onRowSelect(SelectEvent event) {
        Candidato e = ((Candidato) event.getObject());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Your message: " + e.getNombre()));
    }

    /**
     * Metodo para decir quien gano
     */
    public void showMessage() {
        int msg = 0;
        String ganador = "";
        for (Candidato listaCandidato1 : this.candidato.getListaCandidato()) {
            for (Candidato listaCandidato2 : this.candidato.getListaCandidato()) {
                if (listaCandidato1.getVoto() < listaCandidato2.getVoto()) {
                    if (listaCandidato2.getVoto() > msg) {
                        System.out.println("NUMERO " + listaCandidato2.getVoto());
                        msg = listaCandidato2.getVoto();
                        ganador = listaCandidato2.getNombre();
                    }
                }
            }
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "EL GANADOR ES", ganador + "  # VOTOS = " + msg);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}
