package com.finalmiguelvilca.trabajofinalmiguelvilca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Matricula;
import com.finalmiguelvilca.trabajofinalmiguelvilca.repo.IGenericRepo;
import com.finalmiguelvilca.trabajofinalmiguelvilca.repo.IMatriculaRepo;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }
}
