package com.PortfolioNancy.NancyEcheverria.Controller;

import com.PortfolioNancy.NancyEcheverria.Dto.dtoPersona;
import com.PortfolioNancy.NancyEcheverria.Entity.Persona;
import com.PortfolioNancy.NancyEcheverria.Interface.IPersonaService;
import com.PortfolioNancy.NancyEcheverria.Security.Controller.Mensaje;
import com.PortfolioNancy.NancyEcheverria.Service.ImpPersonaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-nancy-echeverria.web.app")
public class PersonaController {
    @Autowired ImpPersonaService ipersonaService;
    @Autowired IPersonaService service;
 
   
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    
   @PutMapping("/personas/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPer){
        //Validamos si existe la ID
        if(!ipersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(ipersonaService.existsByNombre(dtoPer.getNombre())&& 
                ipersonaService.getByNombre(dtoPer.getNombre()).get().getId()!= id)
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if(StringUtils.isBlank(dtoPer.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
     Persona persona =  ipersonaService.getOne(id).get();
       persona.setNombre(dtoPer.getNombre());
      persona.setApellido((dtoPer.getApellido()));
       persona.setImg((dtoPer.getImg()));
       persona.setPortada((dtoPer.getPortada()));
        persona.setDescripcion((dtoPer.getDescripcion()));
       persona.setUbicacion((dtoPer.getUbicacion()));
       
       
       
       ipersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
            
    }
    
 @GetMapping("/personas/detail/{id}")
    
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!ipersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
        
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((int)1);
    }
}

   
    
