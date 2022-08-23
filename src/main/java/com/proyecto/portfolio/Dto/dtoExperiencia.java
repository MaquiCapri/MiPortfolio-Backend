
package com.proyecto.portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String curso;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String fecha, String curso) {
        this.fecha = fecha;
        this.curso = curso;
    }
    
    //getter and setter

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
}


