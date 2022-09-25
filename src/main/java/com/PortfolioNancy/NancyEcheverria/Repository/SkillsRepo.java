
package com.PortfolioNancy.NancyEcheverria.Repository;

import com.PortfolioNancy.NancyEcheverria.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Integer> {
    
public Optional<Skills> findByNombre(String nombre);

public boolean existsByNombre(String nombre);
    
    
}
