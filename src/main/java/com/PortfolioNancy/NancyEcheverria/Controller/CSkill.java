package com.PortfolioNancy.NancyEcheverria.Controller;

import com.PortfolioNancy.NancyEcheverria.Dto.dtoSkills;
import com.PortfolioNancy.NancyEcheverria.Entity.Skills;
import com.PortfolioNancy.NancyEcheverria.Security.Controller.Mensaje;
import com.PortfolioNancy.NancyEcheverria.Service.SkillsService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "https://portfolio-nancy-echeverria.web.app")

public class CSkill {

    @Autowired
    SkillsService skillsService;
 @GetMapping("/lista")
   public ResponseEntity<List<Skills>> list(){
        List<Skills> list =  skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoSk) {
        if (StringUtils.isBlank(dtoSk.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillsService.existsByNombre(dtoSk.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

         Skills skills= new Skills(dtoSk.getNombre(), dtoSk.getImagen(), dtoSk.getColorInterior(), dtoSk.getColorExterno(), dtoSk.getPorcentaje());
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoSk) {
        //Validamos si existe la ID
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Skill
        if (skillsService.existsByNombre(dtoSk.getNombre())
                && skillsService.getByNombreE(dtoSk.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //No puede estar vacio
        if (StringUtils.isBlank(dtoSk.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = skillsService.getOne(id).get();
        skills.setNombre(dtoSk.getNombre());
        skills.setImagen(dtoSk.getImagen());
        skills.setColorInterior(dtoSk.getColorInterior());
        skills.setColorExterno(dtoSk.getColorExterno());
        skills.setPorcentaje(dtoSk.getPorcentaje());
       
       

        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);

    }

}
