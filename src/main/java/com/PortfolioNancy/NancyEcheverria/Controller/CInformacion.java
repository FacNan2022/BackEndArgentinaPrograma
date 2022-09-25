
package com.PortfolioNancy.NancyEcheverria.Controller;

import com.PortfolioNancy.NancyEcheverria.Dto.dtoInformacion;
import com.PortfolioNancy.NancyEcheverria.Entity.Informacion;
import com.PortfolioNancy.NancyEcheverria.Security.Controller.Mensaje;
import com.PortfolioNancy.NancyEcheverria.Service.SInformacion;
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
@RequestMapping("/informacion")
@CrossOrigin(origins = "https://portfolio-nancy-echeverria.web.app")
public class CInformacion {
   @Autowired
    SInformacion sInformacion;   
   
   @GetMapping("/lista")
    public ResponseEntity<List<Informacion>> list(){
        List<Informacion> list =  sInformacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    
    public ResponseEntity<Informacion> getById(@PathVariable("id") int id){
        if(!sInformacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Informacion informacion = sInformacion.getOne(id).get();
        return new ResponseEntity(informacion, HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sInformacion.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sInformacion.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoInformacion dtoInfo){
        if(StringUtils.isBlank(dtoInfo.getInfoB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sInformacion.existsByNombre(dtoInfo.getInfoB()))
            return new ResponseEntity(new Mensaje("Esta informacion no existe"), HttpStatus.BAD_REQUEST);
        
        Informacion informacion= new Informacion(dtoInfo.getInfoB(),dtoInfo.getInfoT());
        sInformacion.save(informacion);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoInformacion dtoInfo){
        //Validamos si existe la ID
        if(!sInformacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sInformacion.existsByNombre(dtoInfo.getInfoB())&& 
                sInformacion.getByNombre(dtoInfo.getInfoB()).get().getId()!= id)
            return new ResponseEntity(new Mensaje("Esa informacion ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if(StringUtils.isBlank(dtoInfo.getInfoB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
       Informacion informacion = sInformacion .getOne(id).get();
      informacion.setHabilidadesBlandas(dtoInfo.getInfoB());
      informacion.setHabilidadesTecnicas((dtoInfo.getInfoT()));
        sInformacion.save(informacion);
        return new ResponseEntity(new Mensaje("Información actualizado"), HttpStatus.OK);
            
    }


   
    
}
