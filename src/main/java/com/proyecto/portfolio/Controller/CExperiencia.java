
package com.proyecto.portfolio.Controller;


import com.proyecto.portfolio.Dto.dtoExperiencia;
import com.proyecto.portfolio.Entity.Experiencia;
import com.proyecto.portfolio.Security.Controller.Mensaje;
import com.proyecto.portfolio.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://frontendport.web.app")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
       //VALIDACIONES
       if(StringUtils.isBlank(dtoexp.getFecha()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    //if(sExperiencia.existsByFecha(dtoexp.getFecha()))
      //  return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
    
    Experiencia experiencia = new Experiencia(dtoexp.getFecha(), dtoexp.getCurso());
    sExperiencia.save(experiencia);
    
    return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
   }
   
   
   @PutMapping("/update/{id}")
   
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
       //validacion si existe el ID
       if(!sExperiencia.existsById(id))
           return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
            
   
   if(StringUtils.isBlank(dtoexp.getFecha()))
       return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    Experiencia experiencia = sExperiencia.getOne(id).get();
    experiencia.setFecha(dtoexp.getFecha());
    experiencia.setCurso(dtoexp.getCurso());
    
    sExperiencia.save(experiencia);
    return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
   }
  
}
