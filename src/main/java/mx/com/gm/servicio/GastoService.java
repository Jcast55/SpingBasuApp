package mx.com.gm.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.Persona;

public interface GastoService {
    public void save(Gasto gasto);

    public void update(Gasto gasto, long id);

    public List<Optional<Gasto>> getAll();

    public List<Optional<Gasto>> getAllByPersona(Persona persona);

    public List<Optional<Gasto>> getAllByFechaGastoBetween(Date fechaGastoStart, Date fechaGastoEnd);

    public List<Optional<Gasto>> findAllByFechaGasto(Date fechaIncicio);

}
