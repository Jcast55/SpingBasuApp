package mx.com.gm.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.gm.Exception.ResourceNotFoundException;
import mx.com.gm.dao.GastoDao;
import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.GastoService;

public class GastoServiceImpl implements GastoService {

    @Autowired
    GastoDao gastoDao;

    @Override
    public void save(Gasto gasto) {
        gastoDao.save(gasto);

    }

    @Override
    public List<Gasto> getAll() {
       
        return gastoDao.findAll();
    }

    @Override
    public List<Gasto> getAllByPersona(Persona persona) {
        
        return gastoDao.findAllByPersona(persona);
    }

    @Override
    public List<Gasto> getAllByFechaGastoBetween(Date fechaGastoStart, Date fechaGastoEnd) {
        return gastoDao.findAllByFechaGastoBetween(fechaGastoStart, fechaGastoEnd);
    }

    @Override
    public List<Gasto> findAllByFechaGasto(Date fechaIncicio) {

        return gastoDao.findAllByFechaGasto(fechaIncicio);

    }


    @Override
    public Gasto getGastoById(long id) {
        return gastoDao.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Gasto", "id", id));
    }

}