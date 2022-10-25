package mx.com.gm.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.Persona;

public interface GastoDao extends JpaRepository<Gasto, Long> {

    List<Optional<Gasto>> findAllByPersona(Persona persona);

    List<Optional<Gasto>> findAllByFechaGasto(Date fechaIncicio);

    List<Optional<Gasto>> findAllByFechaGastoBetween(Date fechaGastoStart, Date fechaGastoEnd);

}
