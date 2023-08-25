package com.example.paic.modelo;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "cdr_logs", schema = "dbo")
public class CdrLogs implements Serializable {

    @Id
    @Column(name = "c_nombre")
    private String cNombre;

    @Column(name = "d_fecha_inicio_carga")
    private Timestamp dFechaInicioCarga;

    @Column(name = "d_final_carga")
    private Timestamp dFechaFinalCarga;

    @Column(name = "n_registro_cargados")
    private Integer nRegistrosCargados;

    @Column(name = "n_registro_fallidos")
    private Integer nRegistroFallidos;


}
