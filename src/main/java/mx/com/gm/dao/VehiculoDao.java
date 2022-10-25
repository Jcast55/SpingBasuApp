package mx.com.gm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Vehiculo;

public interface VehiculoDao extends JpaRepository<Vehiculo, Long>{
    List<Optional<Vehiculo>> findAllByPersona(Persona persona);
}
