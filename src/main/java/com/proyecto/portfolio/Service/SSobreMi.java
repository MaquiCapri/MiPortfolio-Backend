
package com.proyecto.portfolio.Service;

import com.proyecto.portfolio.Entity.SobreMi;
import com.proyecto.portfolio.Repository.RSobreMi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSobreMi {
     @Autowired
    RSobreMi rSobreMi;
    
    public List<SobreMi> list(){
        return rSobreMi.findAll();
    }
    
    public Optional <SobreMi> getOne(int id){
        return rSobreMi.findById(id);
    }
    
     public Optional <SobreMi> getByFecha(String perfil){
        return rSobreMi.findByPerfil(perfil);
    }
     
     public void save(SobreMi sobre){
         rSobreMi.save(sobre);
     }
     
     public void delete(int id){
         rSobreMi.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rSobreMi.existsById(id);
     }
     
     public boolean existsByFecha(String perfil){
         return rSobreMi.existsByPerfil(perfil);
     }
}
