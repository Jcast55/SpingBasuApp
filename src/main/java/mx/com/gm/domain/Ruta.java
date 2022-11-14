package mx.com.gm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "ruta")
public class Ruta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty
    private String dirrecion;

    @NotEmpty
    private int cantidadCasas;

    @NotEmpty
    private double tarifa;
    

    @JoinColumn(name = "f_R_Persona")
    @ManyToOne
    private ReportePersona rPersona;
}
