package mx.com.gm.servicio;

import java.util.List;

import mx.com.gm.domain.Rol;

public interface RolService {
    public Rol rolSave(Rol rol);
    public List<Rol> findAllRol(); 
    public Rol findByIdRol(long id);
    public void deleteRol(Rol rol);
}
