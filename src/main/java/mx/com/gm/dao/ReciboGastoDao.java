package mx.com.gm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.domain.Gasto;
import mx.com.gm.domain.ReciboGasto;
import mx.com.gm.domain.Vehiculo;

public interface ReciboGastoDao extends JpaRepository<ReciboGasto, Long>{
    
    List<ReciboGasto> findAllByVehiculo(Vehiculo vehiculo);

    List<ReciboGasto> findAllByGasto(Gasto gasto);

}
