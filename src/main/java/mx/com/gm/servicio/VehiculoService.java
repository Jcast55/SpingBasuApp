package mx.com.gm.servicio;

import java.util.List;
import java.util.Optional;

import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Vehiculo;

public interface VehiculoService {
    Vehiculo saveVehiculo(Vehiculo vehiculo);

    List<VehiculoService> getAllVehiculo();

    Vehiculo updVehiculo(VehiculoService vehiculo, long id);

    void deleteVehiculo(long id);
    
    Vehiculo getVehiculoById(long id);
    
    List<Optional<VehiculoService>> getAllVehiculosByPersona(Persona persona);

}
