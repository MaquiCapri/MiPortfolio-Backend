
package com.proyecto.portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String descriptionE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String fecha, String descriptionE) {
        this.fecha = fecha;
        this.descriptionE = descriptionE;
    }
    
    //getter and setter

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
    
    
}


