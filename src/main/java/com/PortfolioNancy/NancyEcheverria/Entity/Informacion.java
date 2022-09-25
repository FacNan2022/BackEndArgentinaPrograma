
package com.PortfolioNancy.NancyEcheverria.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Informacion {
    @Id
    private int id;
    private String habilidadesBlandas;
    private String habilidadesTecnicas;

    public Informacion() {
    }

    public Informacion(String habilidadesBlandas, String habilidadesTecnicas) {
        this.habilidadesBlandas = habilidadesBlandas;
        this.habilidadesTecnicas = habilidadesTecnicas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabilidadesBlandas() {
        return habilidadesBlandas;
    }

    public void setHabilidadesBlandas(String habilidadesBlandas) {
        this.habilidadesBlandas = habilidadesBlandas;
    }

    public String getHabilidadesTecnicas() {
        return habilidadesTecnicas;
    }

    public void setHabilidadesTecnicas(String habilidadesTecnicas) {
        this.habilidadesTecnicas = habilidadesTecnicas;
    }
    
    
    
    
}
