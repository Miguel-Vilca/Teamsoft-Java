package com.finalmiguelvilca.trabajofinalmiguelvilca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleMatricula;
    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_CURSO"))
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "idMatricula", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_MATRICULA"))
    private Matricula matricula;
    @Column(nullable = false, length = 20)
    private String aula;
}
