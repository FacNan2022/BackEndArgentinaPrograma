package com.PortfolioNancy.NancyEcheverria.Service;

import com.PortfolioNancy.NancyEcheverria.Entity.Persona;
import com.PortfolioNancy.NancyEcheverria.Interface.IPersonaService;
import com.PortfolioNancy.NancyEcheverria.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
   public Optional<Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
      public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
                }
        public boolean existsByNombre (String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
           public Optional<Persona> getByNombre(String persona){
        return ipersonaRepository.findByNombre(persona);
    }
      public void save(Persona per){
        ipersonaRepository.save(per);
    }
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

  

    


}