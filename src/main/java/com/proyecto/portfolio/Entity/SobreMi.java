
package com.proyecto.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SobreMi {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String perfil;
    private String sobremi;
    
    //constructores

    public SobreMi() {
    }

    public SobreMi(String perfil, String sobremi) {
        this.perfil = perfil;
        this.sobremi = sobremi;
    }

  
    
    //setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSobremi() {
        return sobremi;
    }

    public void setSobremi(String sobremi) {
        this.sobremi = sobremi;
    }

   
}
