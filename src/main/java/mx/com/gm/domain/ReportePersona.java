package mx.com.gm.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Table(name = "reporte_Persona")
@Entity
public class ReportePersona {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "f_persona")
    private Persona persona;

    @NotEmpty
    private String descripcion;


    @OneToMany(mappedBy = "rPersona", fetch = FetchType.EAGER)
    private List<Ruta> rutas;



}
