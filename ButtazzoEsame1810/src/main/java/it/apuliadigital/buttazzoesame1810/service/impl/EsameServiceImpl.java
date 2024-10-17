package it.apuliadigital.buttazzoesame1810.service.impl;

import it.apuliadigital.buttazzoesame1810.mapper.DtoToEsameEntity;
import it.apuliadigital.buttazzoesame1810.mapper.EsameEntityToDto;
import it.apuliadigital.buttazzoesame1810.repository.EsameRepository;
import it.apuliadigital.buttazzoesame1810.service.EsameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsameServiceImpl implements EsameService {

    @Autowired
    EsameRepository esameRepository;

    @Autowired
    DtoToEsameEntity dtoToEsameEntity;

    @Autowired
    EsameEntityToDto esameEntityToDto;
}
