package mx.com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long>{
    
}
