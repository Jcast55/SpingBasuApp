package mx.com.gm.servicio;

import java.util.List;

import mx.com.gm.domain.Usuario;

public interface Uservice {
    public Usuario userSave(Usuario user);
    public Usuario findByIdUsuario(long id);
    public List<Usuario> findAllUsuario();
}
