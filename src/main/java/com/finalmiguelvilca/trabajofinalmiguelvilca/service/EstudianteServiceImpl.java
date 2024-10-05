package com.finalmiguelvilca.trabajofinalmiguelvilca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Estudiante;
import com.finalmiguelvilca.trabajofinalmiguelvilca.repo.IEstudianteRepo;
import com.finalmiguelvilca.trabajofinalmiguelvilca.repo.IGenericRepo;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService {
    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }
}
