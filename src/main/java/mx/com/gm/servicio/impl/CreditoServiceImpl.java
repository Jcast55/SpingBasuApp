package mx.com.gm.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.gm.Exception.ResourceNotFoundException;
import mx.com.gm.dao.CreditoDao;
import mx.com.gm.domain.Credito;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.CreditoService;

@Service
public class CreditoServiceImpl implements CreditoService {

    @Autowired
    private CreditoDao creditoDao;

    @Override
    public void saveCredito(Credito credito) {
        creditoDao.save(credito);
    }

    @Override
    public List<Credito> getAllCredito() {

        List<Credito> creditos = creditoDao.findAll();
        return creditos;
    }

    @Override
    public Credito getCreditoById(long id) {
        return creditoDao.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Trabajador", "id", id));
    }

    @Override
    public List<Credito> getAllCreditoByPersona(Persona persona) {
        return creditoDao.findAllByPersona(persona);
    }

    @Override
    public List<Credito> getAllCreditosFecha(Date fechaIncio, Date fechaFinal) {
        return creditoDao.findAlLByFechaInicioBetween(fechaIncio, fechaIncio);
    }

    @Override
    public void deleteCredito(long id) {
        Credito credito = getCreditoById(id);
        creditoDao.delete(credito);
    }

    @Override
    public Credito updateCoutas(Credito credito, int couta, Double total) {
        credito.setCuotas(credito.getCuotas() - 1);
        credito.setTotalF(credito.getTotalF() - total);
        creditoDao.save(credito);
        return credito;
    }

}
