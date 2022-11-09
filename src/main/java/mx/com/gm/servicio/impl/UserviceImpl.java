package mx.com.gm.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.gm.Exception.ResourceNotFoundException;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Usuario;
import mx.com.gm.servicio.Uservice;

@Service
public class UserviceImpl implements Uservice {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario userSave(Usuario user) {
        return usuarioDao.save(user);
    }

    @Override
    public Usuario findByIdUsuario(long id) {
    Usuario user =   usuarioDao.findById(id).orElseThrow(() 
    -> new ResourceNotFoundException("Usuario", "id", id));
        return user;
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return usuarioDao.findAll();
    }
    
}
