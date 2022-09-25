
package com.PortfolioNancy.NancyEcheverria.Repository;

import com.PortfolioNancy.NancyEcheverria.Entity.Informacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformacionRepo extends JpaRepository<Informacion, Integer>{

public Optional<Informacion> findByhabilidadesBlandas(String habilidadesBlandas);

public boolean existsByhabilidadesBlandas(String habilidadesBlandas);
    
}
