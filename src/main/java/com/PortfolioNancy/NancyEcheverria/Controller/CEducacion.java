
package com.PortfolioNancy.NancyEcheverria.Controller;

import com.PortfolioNancy.NancyEcheverria.Dto.dtoEducacion;
import com.PortfolioNancy.NancyEcheverria.Entity.Educacion;
import com.PortfolioNancy.NancyEcheverria.Security.Controller.Mensaje;
import com.PortfolioNancy.NancyEcheverria.Service.Seducacion;
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
@RequestMapping("/edu")
@CrossOrigin(origins = "https://portfolio-nancy-echeverria.web.app")
public class CEducacion {
    @Autowired
    Seducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByInstitucion(dtoEdu.getInstitucion()))
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoEdu.getInstitucion(), dtoEdu.getTitulo(), dtoEdu.getOrientacion(), dtoEdu.getFechaInicio(), dtoEdu.getFechaFinalizacion());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu){
        //Validamos si existe la ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sEducacion.existsByInstitucion(dtoEdu.getInstitucion())&& 
                sEducacion.getByInstitucion(dtoEdu.getInstitucion()).get().getId()!= id)
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if(StringUtils.isBlank(dtoEdu.getInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
       educacion.setInstitucion(dtoEdu.getInstitucion());
      educacion.setTitulo((dtoEdu.getTitulo()));
       educacion.setOrientacion((dtoEdu.getOrientacion()));
        educacion.setFechaInicio((dtoEdu.getFechaInicio()));
         educacion.setFechaFinalizacion((dtoEdu.getFechaFinalizacion()));
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
            
    }


   
    
}

