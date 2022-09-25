
package com.PortfolioNancy.NancyEcheverria.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombreE;
    private String puesto;
    private String descripcionE;
    private String fechaInicio;
    private String fechaFinalizacion;
//constructor vacio
    public Experiencia() {
    }
//constructor sin id
    public Experiencia(String nombreE, String puesto, String descripcionE, String fechaInicio, String fechaFinalizacion) {
        this.nombreE = nombreE;
        this.puesto = puesto;
        this.descripcionE = descripcionE;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
//getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
   
    
}
