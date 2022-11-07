package mx.com.gm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.Persona;

public interface GastoDao extends JpaRepository<Gasto, Long> {

    List<Gasto> findAllByPersona(Persona persona);

    List<Gasto> findAllByFechaGasto(Date fechaIncicio);

    List<Gasto> findAllByFechaGastoBetween(Date fechaGastoStart, Date fechaGastoEnd);

}
