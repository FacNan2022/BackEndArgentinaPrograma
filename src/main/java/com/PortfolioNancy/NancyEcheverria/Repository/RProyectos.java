
package com.PortfolioNancy.NancyEcheverria.Repository;

import com.PortfolioNancy.NancyEcheverria.Entity.Experiencia;
import com.PortfolioNancy.NancyEcheverria.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RProyectos  extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByNombre(String nombre);

public boolean existsByNombre(String nombre);
}
