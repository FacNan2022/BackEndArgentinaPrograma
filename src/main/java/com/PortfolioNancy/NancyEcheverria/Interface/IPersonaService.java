package com.PortfolioNancy.NancyEcheverria.Interface;

import com.PortfolioNancy.NancyEcheverria.Entity.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(int id);
    
    //Buscar una persona por ID
    public Persona findPersona(int id);


  
}