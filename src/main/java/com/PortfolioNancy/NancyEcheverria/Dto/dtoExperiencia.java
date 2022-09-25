
package com.PortfolioNancy.NancyEcheverria.Dto;

import javax.validation.constraints.NotBlank;



public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String puesto;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFinalizacion;
    
    //constructor vacio

    public dtoExperiencia() {
    }
    //constructores

    public dtoExperiencia(String nombreE, String puesto, String descripcionE, String fechaInicio, String fechaFinalizacion) {
        this.nombreE = nombreE;
        this.puesto = puesto;
        this.descripcionE = descripcionE; 
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    //getter y setter

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    

    
    
}
