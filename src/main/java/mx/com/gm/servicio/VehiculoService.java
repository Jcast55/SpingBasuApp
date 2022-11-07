package mx.com.gm.servicio;

import java.util.List;

import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Vehiculo;

public interface VehiculoService {
    Vehiculo saveVehiculo(Vehiculo vehiculo);

    List<Vehiculo> getAllVehiculo();

    Vehiculo updVehiculo(Vehiculo vehiculo, long id);

    void deleteVehiculo(long id);

    Vehiculo getVehiculoById(long id);

    List<Vehiculo> getAllVehiculosByPersona(Persona persona);

}
