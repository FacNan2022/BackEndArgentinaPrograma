
package com.PortfolioNancy.NancyEcheverria.Service;

import com.PortfolioNancy.NancyEcheverria.Entity.Proyectos;
import com.PortfolioNancy.NancyEcheverria.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    
  @Autowired
    RProyectos rProyectos;
    
    public List<Proyectos> list(){
    return rProyectos.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return rProyectos.findByNombre(nombre);
    }
    
    public void save(Proyectos pro){
        rProyectos.save(pro);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rProyectos.existsByNombre(nombre);
    }
    
}
