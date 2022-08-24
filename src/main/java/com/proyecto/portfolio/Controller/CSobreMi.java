
package com.proyecto.portfolio.Controller;


import com.proyecto.portfolio.Dto.dtoSobreMi;
import com.proyecto.portfolio.Entity.SobreMi;
import com.proyecto.portfolio.Security.Controller.Mensaje;
import com.proyecto.portfolio.Service.SSobreMi;
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
@RequestMapping("/sobrem")
@CrossOrigin(origins = "https://frontendport.web.app")

public class CSobreMi {
    @Autowired
    SSobreMi sSobreMi;
    
    @GetMapping("/lista")
    public ResponseEntity<List<SobreMi>> list(){
        List<SobreMi> list = sSobreMi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SobreMi> getById(@PathVariable("id") int id){
        if(!sSobreMi.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SobreMi sobreMi = sSobreMi.getOne(id).get();
        return new ResponseEntity(sobreMi, HttpStatus.OK);
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSobreMi.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSobreMi.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoSobreMi dtosobre){
       //VALIDACIONES
       if(StringUtils.isBlank(dtosobre.getPerfil()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    SobreMi sobreMi = new SobreMi(dtosobre.getPerfil(), dtosobre.getSobremi());
    sSobreMi.save(sobreMi);
    
    return new ResponseEntity(new Mensaje("Texto agregado"), HttpStatus.OK);
   }
   
   
   @PutMapping("/update/{id}")
   
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSobreMi dtosobre){
       //validacion si existe el ID
       if(!sSobreMi.existsById(id))
           return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
            
   
   if(StringUtils.isBlank(dtosobre.getPerfil()))
       return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    SobreMi sobreMi = sSobreMi.getOne(id).get();
    sobreMi.setPerfil(dtosobre.getPerfil());
    sobreMi.setSobremi(dtosobre.getSobremi());
    
    sSobreMi.save(sobreMi);
    return new ResponseEntity(new Mensaje("Texto actualizado"), HttpStatus.OK);
   }
   
    @GetMapping("/traer/perfil")
  public SobreMi findSobreMi(){
      return sSobreMi.findSobreMi((Integer)1);
  }
  
}
