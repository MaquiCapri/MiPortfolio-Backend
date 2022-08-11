
package com.proyecto.portfolio.Interface;

import com.proyecto.portfolio.Entity.Persona;
import java.util.List;


public interface IPersonaService {
     //traer una lista de personas
    public List<Persona> getPersona();
    
    //traer un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto buscandolo por id
    public void deletePersona(Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);

}
