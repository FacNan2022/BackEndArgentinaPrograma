
package com.PortfolioNancy.NancyEcheverria.Dto;

import javax.validation.constraints.NotBlank;

public class dtoInformacion {
    @NotBlank
    private String infoB;
    @NotBlank
    private String infoT;

    public dtoInformacion() {
    }

    public dtoInformacion(String infoB, String infoT) {
        this.infoB = infoB;
        this.infoT = infoT;
    }

    public String getInfoB() {
        return infoB;
    }

    public void setInfoB(String infoB) {
        this.infoB = infoB;
    }

    public String getInfoT() {
        return infoT;
    }

    public void setInfoT(String infoT) {
        this.infoT = infoT;
    }
    
    
   
   
}
