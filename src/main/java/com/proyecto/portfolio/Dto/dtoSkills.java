
package com.proyecto.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
     @NotBlank
    private int porcentaje;
    
    @NotBlank
    private String texto;

    public dtoSkills() {
    }

    public dtoSkills(int porcentaje, String texto) {
        this.porcentaje = porcentaje;
        this.texto = texto;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
