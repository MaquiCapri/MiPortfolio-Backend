
package com.proyecto.portfolio.Service;

import com.proyecto.portfolio.Entity.Experiencia;
import com.proyecto.portfolio.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Optional <Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
     public Optional <Experiencia> getByFecha(String fecha){
        return rExperiencia.findByFecha(fecha);
    }
     
     public void save(Experiencia expe){
         rExperiencia.save(expe);
     }
     
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     
     public boolean existsByFecha(String fecha){
         return rExperiencia.existsByFecha(fecha);
     }
}
