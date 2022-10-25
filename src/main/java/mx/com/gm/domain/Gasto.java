package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "gasto")
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "fecha_gasto", updatable = false)
    private Date fechaGasto;

    @NotEmpty
    @Column
    private String descripcion;

    @NotEmpty
    @Column
    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "f_persona")
    private Persona persona;

}
