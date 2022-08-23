
package com.proyecto.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSobreMi {
     @NotBlank
    private String perfil;
    
    @NotBlank
    private String sobremi;

    public dtoSobreMi() {
    }

    public dtoSobreMi(String perfil, String sobremi) {
        this.perfil = perfil;
        this.sobremi = sobremi;
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
