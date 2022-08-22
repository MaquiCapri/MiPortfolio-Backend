
package com.proyecto.portfolio.Service;


import com.proyecto.portfolio.Entity.Skills;
import com.proyecto.portfolio.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
  @Autowired
   //inyectamos el repositorio de skills       
  RSkills rSkills;
  
  //armar una lista con todos los skills que encuentre
   public List<Skills> list(){
        return rSkills.findAll();
    }
    
   
    public Optional <Skills> getOne(int id){
        return rSkills.findById(id);
    }
    
     public Optional <Skills> getByPorcentaje(int porcentaje){
        return rSkills.findByPorcentaje(porcentaje);
    }
     //para guardar un tipo de dato tipo skills. va a traer un objeto
     public void save(Skills skill){
         rSkills.save(skill);
     }
     //busca el objeto por id y lo borra
     public void delete(int id){
         rSkills.deleteById(id);
     }
     
     //si exite el id que busco
     public boolean existsById(int id){
         return rSkills.existsById(id);
     }
     
     public boolean existsByPorcentaje(int porcentaje){
         return rSkills.existsByPorcentaje(porcentaje);
     }
}
