package mx.com.gm.servicio;

import java.util.Date;
import java.util.List;

import mx.com.gm.domain.Credito;
import mx.com.gm.domain.Persona;

public interface CreditoService {
   
    void saveCredito(Credito credito);

    public List<Credito> getAllCredito();

    public Credito getCreditoById(long id);

    public List<Credito> getAllCreditoByPersona(Persona persona);

    public List<Credito> getAllCreditosFecha(Date fechaIncio, Date fechaFinal);

    void deleteCredito(long id);
    
    public Credito updateCoutas(Credito credito, int couta, double total); 
}
