package mx.com.gm.servicio;

import java.util.List;
import java.util.Optional;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.ReciboGasto;
import mx.com.gm.domain.Vehiculo;

public interface ReciboGastoService {
    public void save(ReciboGasto reciboGasto);

    public void update(ReciboGasto reciboGasto, long id);

    public List<Optional<ReciboGasto>> getAllReciboGasto();

    public List<Optional<ReciboGasto>> getAllByVehiculo(Vehiculo vehiculo);

    public List<Optional<ReciboGasto>> getAllByGasto(Gasto gasto);
    
}
