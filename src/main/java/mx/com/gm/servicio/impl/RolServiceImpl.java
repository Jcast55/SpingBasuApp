package mx.com.gm.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.gm.Exception.ResourceNotFoundException;
import mx.com.gm.dao.RolDao;
import mx.com.gm.domain.Rol;
import mx.com.gm.servicio.RolService;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolDao rolDao;
    @Override
    public Rol rolSave(Rol rol) {
        return rolDao.save(rol);
    }

    @Override
    public List<Rol> findAllRol() {
        return rolDao.findAll();
    }

    @Override
    public Rol findByIdRol(long id) {
        return rolDao.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Credito", "id", id));
    
    }

    @Override
    public void deleteRol(Rol rol) {
    rolDao.delete(rol);        
    }
    
}
