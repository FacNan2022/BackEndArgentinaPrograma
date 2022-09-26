
package com.PortfolioNancy.NancyEcheverria.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {
      @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String animacion;
    @NotBlank String descripcion;
    @NotBlank String ubicacion;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String animacion,String descripcion, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.animacion = animacion;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAnimacion() {
        return animacion;
    }

    public void setAnimacion(String animacion) {
        this.animacion = animacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
           

}