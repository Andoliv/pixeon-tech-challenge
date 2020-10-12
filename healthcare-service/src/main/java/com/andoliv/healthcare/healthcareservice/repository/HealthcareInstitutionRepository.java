package com.andoliv.healthcare.healthcareservice.repository;

import com.andoliv.healthcare.healthcareservice.model.HealthcareInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthcareInstitutionRepository extends JpaRepository<HealthcareInstitution, Long> {

    Optional<HealthcareInstitution> findByNameEquals(String name);

    Optional<HealthcareInstitution> findByNameContains(String name);

    Optional<HealthcareInstitution> findByCnpjEquals(String cnpj);

}
