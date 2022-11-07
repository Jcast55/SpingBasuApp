package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "credito")
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_persona")
    private Persona persona;

    @Column(name = "fecha_inicial")
    private Date fechaInicio;

    @Column(name = "fecha_final")
    private Date fechaFinal;

    @NotNull
    private int cuotas;

    @NotNull

    private double totalF;

    @NotNull
    private double totalI;
}
