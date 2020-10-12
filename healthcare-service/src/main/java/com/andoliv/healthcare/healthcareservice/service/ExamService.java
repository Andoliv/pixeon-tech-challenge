package com.andoliv.healthcare.healthcareservice.service;

import com.andoliv.healthcare.healthcareservice.exception.ExamNotFoundException;
import com.andoliv.healthcare.healthcareservice.exception.InstitutionNotFoundException;
import com.andoliv.healthcare.healthcareservice.exception.InstitutionOutOfBudgetException;
import com.andoliv.healthcare.healthcareservice.external.ExtExam;
import com.andoliv.healthcare.healthcareservice.model.Exam;
import com.andoliv.healthcare.healthcareservice.model.HealthcareInstitution;
import com.andoliv.healthcare.healthcareservice.repository.ExamRepository;
import com.andoliv.healthcare.healthcareservice.repository.HealthcareInstitutionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamService {

    private final ExamRepository repository;
    private final HealthcareInstitutionRepository institutionRepository;
    private final ModelMapper mapper;

    @Autowired
    public ExamService(ExamRepository repository, HealthcareInstitutionRepository institutionRepository, ModelMapper mapper) {
        this.repository = repository;
        this.institutionRepository = institutionRepository;
        this.mapper = mapper;
    }

    @Transactional
    public ExtExam createExam(long institutionId, ExtExam extExam) {
        Exam exam = mapper.map(extExam, Exam.class);
        HealthcareInstitution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new InstitutionNotFoundException(String.format("No institution was found with id: %d", institutionId)));
        exam.setHealthcareInstitution(institution);

        budgetValidate(institution);
        repository.save(exam);
        doDecreaseOneCoin(institution);

        return mapper.map(exam, ExtExam.class);
    }

    private void budgetValidate(HealthcareInstitution institution) {
        if (!validateBudget(institution)) {
            throw new InstitutionOutOfBudgetException(
                    String.format("Institution out of budget id: %d - Pixeon Coins: %d", institution.getId(), institution.getPixeonCoins())
            );
        }
    }

    public Page<ExtExam> getExtExamsByInstitutionId(long id, Pageable page) {
        HealthcareInstitution institution = institutionRepository.findById(id).orElseThrow(() -> new InstitutionNotFoundException(
                String.format("No institution was found with id: %d", id)));

        Set<ExtExam> extExams = new HashSet<>();

        Page<Exam> pageExams = findExamsByHealthcareInstitution(institution, page);
        pageExams.getContent().forEach(exam -> {

            if (!exam.isExamRetrieved()) {
                budgetValidate(institution);
                doDecreaseOneCoin(institution);
                updateWithRetrievedExam(exam);
            }

            extExams.add(mapper.map(exam, ExtExam.class));
        });

        return new PageImpl<>(new ArrayList<>(extExams), pageExams.getPageable(), pageExams.getSize());
    }

    @Transactional
    public ExtExam getExtExamByIdAndInstitutionId(long institution_id, long exam_id) {
        HealthcareInstitution institution = institutionRepository.findById(institution_id)
                .orElseThrow(() -> new InstitutionNotFoundException(String.format("No institution was found with id: %d", institution_id)));
        Exam exam = repository.findByIdAndHealthcareInstitution(exam_id, institution)
                .orElseThrow(() -> new ExamNotFoundException(String.format("No exam was found with id: %d for institution with id: %d", exam_id, institution_id)));

        if (!exam.isExamRetrieved()) {
            budgetValidate(institution);
            doDecreaseOneCoin(institution);
            updateWithRetrievedExam(exam);
        }

        return mapper.map(exam, ExtExam.class);
    }

    @Transactional
    public ExtExam updateExam(long institution_id, long exam_id, ExtExam extExam) {
        HealthcareInstitution institution = institutionRepository.findById(institution_id).orElseThrow(() -> new InstitutionNotFoundException(
                String.format("No institution was found with id: %d", institution_id)));
        Exam exam = repository.findByIdAndHealthcareInstitution(exam_id, institution).orElseThrow(() -> new ExamNotFoundException(
                String.format("No exam was found with id: %d for institution with id: %d", exam_id, institution_id)));

        updateExamEntity(exam, extExam);
        repository.save(exam);

        return mapper.map(exam, ExtExam.class);
    }

    @Transactional
    public void deleteExam(long exam_id) {
        repository.deleteById(exam_id);
    }

    private boolean validateBudget(HealthcareInstitution institution) {
        return institution.getPixeonCoins() > 0;
    }

    private Page<Exam> findExamsByHealthcareInstitution(HealthcareInstitution institution, Pageable page) {
        return repository.findAllByHealthcareInstitution(institution, page);
    }

    private void doDecreaseOneCoin(HealthcareInstitution institution) {
        institution.setPixeonCoins(institution.getPixeonCoins() - 1);
        institutionRepository.save(institution);
    }

    private void updateWithRetrievedExam(Exam exam) {
        exam.setExamRetrieved(Boolean.TRUE);
        repository.save(exam);
    }

    private void updateExamEntity(Exam exam, ExtExam extExam) {
        if (extExam.getPatientAge() != null) {
            exam.setPatientAge(extExam.getPatientAge());
        }
        if (extExam.getPatientName() != null) {
            exam.setPatientName(extExam.getPatientName());
        }
        if (extExam.getPatientGender() != null) {
            exam.setPatientGender(extExam.getPatientGender());
        }
        if (extExam.getPhysicianName() != null) {
            exam.setPhysicianName(extExam.getPhysicianName());
        }
        if (extExam.getPhysicianCRM() != null) {
            exam.setPhysicianCRM(extExam.getPhysicianCRM());
        }
        if (extExam.getProcedureName() != null) {
            exam.setProcedureName(extExam.getProcedureName());
        }
    }
}
