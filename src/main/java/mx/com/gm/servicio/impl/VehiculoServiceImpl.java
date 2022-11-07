package mx.com.gm.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.gm.Exception.ResourceNotFoundException;
import mx.com.gm.dao.VehiculoDao;
import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Vehiculo;
import mx.com.gm.servicio.VehiculoService;

public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoDao vehiculoDao;

    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.save(vehiculo);
    }

    @Override
    public List<Vehiculo> getAllVehiculo() {
        return vehiculoDao.findAll();
    }

    @Override
    public Vehiculo updVehiculo(Vehiculo vehiculo, long id) {
        Vehiculo vehiculo2 = getVehiculoById(id);
        vehiculo2.setPersona(vehiculo.getPersona());
        vehiculo2.setPlaca(vehiculo.getPlaca());
        vehiculo2.setModelo(vehiculo.getModelo());
        vehiculo2.setDescripcion(vehiculo.getDescripcion());
        return vehiculoDao.save(vehiculo2);
    }

    @Override
    public void deleteVehiculo(long id) {
        vehiculoDao.delete(getVehiculoById(id));
    }

    @Override
    public Vehiculo getVehiculoById(long id) {

        return vehiculoDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehiculo", "id", id));
    }

    @Override
    public List<Vehiculo> getAllVehiculosByPersona(Persona persona) {
        return vehiculoDao.findAllByPersona(persona);
    }

}
