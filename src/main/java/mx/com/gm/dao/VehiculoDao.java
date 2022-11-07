package mx.com.gm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Vehiculo;

public interface VehiculoDao extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findAllByPersona(Persona persona);
}
