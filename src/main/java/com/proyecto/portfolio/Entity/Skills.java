
package com.proyecto.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Skills {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int porcentaje;
    private String texto;

    public Skills() {
    }

    public Skills(int porcentaje, String texto) {
        this.porcentaje = porcentaje;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
