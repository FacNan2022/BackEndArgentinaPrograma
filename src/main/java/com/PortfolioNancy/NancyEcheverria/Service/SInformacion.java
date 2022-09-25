
package com.PortfolioNancy.NancyEcheverria.Service;

import com.PortfolioNancy.NancyEcheverria.Entity.Informacion;
import com.PortfolioNancy.NancyEcheverria.Repository.IInformacionRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SInformacion {
    @Autowired
  IInformacionRepo iInfoRepo;
    
    public List<Informacion> list(){
    return iInfoRepo.findAll();
    }
    
    public Optional<Informacion> getOne(int id){
        return iInfoRepo.findById(id);
    }
    
    public Optional<Informacion> getByNombre(String habilidadesBlandas){
        return iInfoRepo.findByhabilidadesBlandas(habilidadesBlandas);
    }
    
    public void save(Informacion info){
       iInfoRepo.save(info);
    }
    
    public void delete(int id){
       iInfoRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iInfoRepo.existsById(id);
    }
    
    public boolean existsByNombre(String habilidadesBlandas){
        return iInfoRepo.existsByhabilidadesBlandas(habilidadesBlandas);
    }
    
}


