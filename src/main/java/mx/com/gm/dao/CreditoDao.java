package mx.com.gm.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Credito;
import mx.com.gm.domain.Persona;

public interface CreditoDao extends JpaRepository<Credito, Long>{

    List<Credito> findAllByPersona (Persona persona);

    Optional<Credito> findByPersona(Persona persona);
    
    List<Credito> findAlLByFechaInicioBetween(Date fechaInicioStart, Date fechaInicioEnd);

}
