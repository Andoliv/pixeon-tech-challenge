package com.andoliv.healthcare.healthcareservice.service;

import com.andoliv.healthcare.healthcareservice.exception.InstitutionNotFoundException;
import com.andoliv.healthcare.healthcareservice.external.ExtHealthcareInstitution;
import com.andoliv.healthcare.healthcareservice.model.HealthcareInstitution;
import com.andoliv.healthcare.healthcareservice.repository.HealthcareInstitutionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HealthcareService {

    private static final int DEFAULT_PIXEON_COINS = 3;

    private final HealthcareInstitutionRepository repository;

    private final ModelMapper mapper;

    @Autowired
    public HealthcareService(HealthcareInstitutionRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public ExtHealthcareInstitution create(ExtHealthcareInstitution extInstitution) {
        Optional<HealthcareInstitution> institutionOptional = repository.findByCnpjEquals(extInstitution.getCnpj());

        if (institutionOptional.isPresent()) {
            return mapper.map(institutionOptional.get(), ExtHealthcareInstitution.class);
        }

        HealthcareInstitution institution = mapper.map(extInstitution, HealthcareInstitution.class);
        institution.setPixeonCoins(DEFAULT_PIXEON_COINS);
        repository.save(institution);

        return mapper.map(institution, ExtHealthcareInstitution.class);
    }

    public Page<ExtHealthcareInstitution> findAll(Pageable page) {
        List<ExtHealthcareInstitution> extHealthcareInstitutions = new ArrayList<>();
        Page<HealthcareInstitution> institutions = repository.findAll(page);

        institutions.getContent().forEach(institution ->
                extHealthcareInstitutions.add(mapper.map(institution, ExtHealthcareInstitution.class)));


        return new PageImpl<>(extHealthcareInstitutions, institutions.getPageable(), institutions.getSize());
    }

    public ExtHealthcareInstitution getExtInstitutionById(long id) {
        HealthcareInstitution institution = repository.findById(id).orElseThrow(() -> new InstitutionNotFoundException(
                String.format("No institution was found with id: %d", id)));

        return mapper.map(institution, ExtHealthcareInstitution.class);
    }

    public HealthcareInstitution findByCnpj(String cnpj) {
        return repository.findByCnpjEquals(cnpj).orElseThrow(() -> new InstitutionNotFoundException(
                String.format("No institution was found with CNPJ: %d", cnpj)));
    }

    public HealthcareInstitution findById(long institutionId) {
        return repository.findById(institutionId).orElseThrow(() -> new InstitutionNotFoundException(
                String.format("No institution was found with id: %d", institutionId)));
    }

    private ExtHealthcareInstitution getExtHealthcareInstitution(HealthcareInstitution institution) {
        ExtHealthcareInstitution extHealthcareInstitution = new ExtHealthcareInstitution();
        extHealthcareInstitution.setId(institution.getId());
        extHealthcareInstitution.setName(institution.getName());
        extHealthcareInstitution.setCnpj(institution.getCnpj());

        return null;
    }

    private HealthcareInstitution getInstitution(ExtHealthcareInstitution extInstitution) {
        HealthcareInstitution institution = new HealthcareInstitution();
        institution.setId(extInstitution.getId());
        institution.setName(extInstitution.getName());
        institution.setCnpj(extInstitution.getCnpj());

        return null;
    }
}
