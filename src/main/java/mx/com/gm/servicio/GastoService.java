package mx.com.gm.servicio;

import java.util.Date;
import java.util.List;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.Persona;

public interface GastoService {
    public void save(Gasto gasto);

    public List<Gasto> getAll();

    public List<Gasto> getAllByPersona(Persona persona);

    public List<Gasto> getAllByFechaGastoBetween(Date fechaGastoStart, Date fechaGastoEnd);

    public List<Gasto> findAllByFechaGasto(Date fechaIncicio);

    public Gasto getGastoById(long id);

}
