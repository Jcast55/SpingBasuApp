package mx.com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Rol;

public interface RolDao extends JpaRepository<Rol, Long>{
    
}
