package com.andoliv.healthcare.healthcareservice.repository;

import com.andoliv.healthcare.healthcareservice.model.Exam;
import com.andoliv.healthcare.healthcareservice.model.HealthcareInstitution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Page<Exam> findAllByHealthcareInstitution(HealthcareInstitution institution, Pageable page);

    Optional<Exam> findByIdAndHealthcareInstitution(long id, HealthcareInstitution institution);
}
