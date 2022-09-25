package com.PortfolioNancy.NancyEcheverria.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String imagen;
    private String ColorInterior;
    private String ColorExterno;
    private String porcentaje;
    

    public Skills() {
    }

    public Skills(String nombre, String imagen, String ColorInterior, String ColorExterno, String porcentaje) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.ColorInterior = ColorInterior;
        this.ColorExterno = ColorExterno;
        this.porcentaje = porcentaje;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getColorInterior() {
        return ColorInterior;
    }

    public void setColorInterior(String ColorInterior) {
        this.ColorInterior = ColorInterior;
    }

    public String getColorExterno() {
        return ColorExterno;
    }

    public void setColorExterno(String ColorExterno) {
        this.ColorExterno = ColorExterno;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }


    

}