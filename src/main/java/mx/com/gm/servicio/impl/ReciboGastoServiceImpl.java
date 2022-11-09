package mx.com.gm.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.gm.dao.ReciboGastoDao;
import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.ReciboGasto;
import mx.com.gm.domain.Vehiculo;
import mx.com.gm.servicio.ReciboGastoService;
@Service
public class ReciboGastoServiceImpl implements ReciboGastoService {

    @Autowired
    private ReciboGastoDao reciboGastoDao;

    @Override
    public void save(ReciboGasto reciboGasto) {
        reciboGastoDao.save(reciboGasto);
    }

    @Override
    public void update(ReciboGasto reciboGasto, long id) {

    }

    @Override
    public List<ReciboGasto> getAllReciboGasto() {
        return reciboGastoDao.findAll();
    }

    @Override
    public List<ReciboGasto> getAllByVehiculo(Vehiculo vehiculo) {
        return reciboGastoDao.findAllByVehiculo(vehiculo);
    }

    @Override
    public List<ReciboGasto> getAllByGasto(Gasto gasto) {
        return reciboGastoDao.findAllByGasto(gasto);
    }

}
