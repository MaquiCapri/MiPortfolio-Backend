
package com.proyecto.portfolio.Controller;


import com.proyecto.portfolio.Dto.dtoSkills;
import com.proyecto.portfolio.Entity.Skills;
import com.proyecto.portfolio.Security.Controller.Mensaje;

import com.proyecto.portfolio.Service.SSkills;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skillpor")
@CrossOrigin(origins = "https://frontendport.web.app")
//@CrossOrigin(origins = " http://localhost:8080")
public class CSkills {
    
     @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
       //VALIDACIONES
       //if(StringUtils.isBlank(dtoskills.getPorcentaje()))
         //   return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
  
    
    Skills skills = new Skills(dtoskills.getPorcentaje(), dtoskills.getTexto());
    sSkills.save(skills);
    
    return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
   }
   
   
   @PutMapping("/update/{id}")
   
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
       //validacion si existe el ID
       if(!sSkills.existsById(id))
           return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
   
   //if(StringUtils.isBlank(dtoexp.getPorcentaje()))
     //  return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
   Skills skills = sSkills.getOne(id).get();
    skills.setPorcentaje(dtoskills.getPorcentaje());
   skills.setTexto((dtoskills.getTexto()));
    
    sSkills.save(skills);
    return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
   }
}
