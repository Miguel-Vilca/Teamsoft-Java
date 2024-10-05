package com.finalmiguelvilca.trabajofinalmiguelvilca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;
    @Column(nullable = false)
    private LocalDateTime fechaMatricula;
    @ManyToOne
    @JoinColumn(name = "idEstudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_MATRICULA_ESTUDIANTE"))
    private Estudiante estudiante;
    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<DetalleMatricula> detalleMatricula;
    @Column(nullable = false)
    private boolean estado;

}
