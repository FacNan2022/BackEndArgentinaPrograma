
package com.PortfolioNancy.NancyEcheverria.Repository;

import com.PortfolioNancy.NancyEcheverria.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByInstitucion(String institucion);
    public boolean existsByInstitucion(String institucion);
    
    
}
