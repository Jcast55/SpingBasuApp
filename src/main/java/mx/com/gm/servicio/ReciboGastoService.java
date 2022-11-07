package mx.com.gm.servicio;

import java.util.List;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.ReciboGasto;
import mx.com.gm.domain.Vehiculo;

public interface ReciboGastoService {
    public void save(ReciboGasto reciboGasto);

    public void update(ReciboGasto reciboGasto, long id);

    public List<ReciboGasto> getAllReciboGasto();

    public List<ReciboGasto> getAllByVehiculo(Vehiculo vehiculo);

    public List<ReciboGasto> getAllByGasto(Gasto gasto);

}
