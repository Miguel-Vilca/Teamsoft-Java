package com.finalmiguelvilca.trabajofinalmiguelvilca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Curso;
import com.finalmiguelvilca.trabajofinalmiguelvilca.repo.ICursoRepo;
import com.finalmiguelvilca.trabajofinalmiguelvilca.repo.IGenericRepo;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService{

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
