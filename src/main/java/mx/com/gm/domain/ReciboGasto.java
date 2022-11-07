package mx.com.gm.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "recibo_gasto")
public class ReciboGasto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Puede ser un gasto independiente de que no sea un carro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_vehiculo")
    private Vehiculo vehiculo;

    // No puede ser nullo
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_gasto")
    private Gasto gasto;

}
