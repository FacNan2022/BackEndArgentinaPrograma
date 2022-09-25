package com.PortfolioNancy.NancyEcheverria.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {

    @NotBlank
    private String nombre;
    @NotBlank
    private String imagen;
    @NotBlank
    private String ColorInterior;
    @NotBlank
    private String ColorExterno;
    @NotBlank
    private String porcentaje;

    public dtoSkills() {
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

    public dtoSkills(String nombre, String imagen, String ColorInterior, String ColorExterno, String porcentaje) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.ColorInterior = ColorInterior;
        this.ColorExterno = ColorExterno;
        this.porcentaje = porcentaje;
    }

}
