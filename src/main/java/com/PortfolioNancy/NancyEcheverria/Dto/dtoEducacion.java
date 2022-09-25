
package com.PortfolioNancy.NancyEcheverria.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;
    @NotBlank
    private String orientacion;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFinalizacion;
    
    //Costructores

    public dtoEducacion() {
    }

    public dtoEducacion(String institucion, String titulo, String orientacion, String fechaInicio, String fechaFinalizacion) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.orientacion = orientacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    //Getter y Setter

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
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
