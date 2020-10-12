package com.andoliv.healthcare.healthcareservice.controller;

import com.andoliv.healthcare.healthcareservice.external.ExtExam;
import com.andoliv.healthcare.healthcareservice.external.ExtHealthcareInstitution;
import com.andoliv.healthcare.healthcareservice.service.ExamService;
import com.andoliv.healthcare.healthcareservice.service.HealthcareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.andoliv.healthcare.healthcareservice.constants.ApiLinks.TRAILING_SLASH;

@RestController
public class HealthcareRestController implements HealthcareController {

    private final HealthcareService service;
    private final ExamService examService;

    @Autowired
    public HealthcareRestController(HealthcareService service, ExamService examService) {
        this.service = service;
        this.examService = examService;
    }

    @Override
    public Page<ExtHealthcareInstitution> findAll(Pageable page){
        return service.findAll(page);
    }

    @Override
    public ExtHealthcareInstitution getExtInstitutionById(@NotNull @PathVariable("id") long id){
        return service.getExtInstitutionById(id);
    }

    @Override
    public ExtHealthcareInstitution createInstitution(@Valid @NotNull @RequestBody() ExtHealthcareInstitution extInstitution) {
        return service.create(extInstitution);
    }

    //TODO Continue updating the interface with the documentation for Swagger from now on.
    @GetMapping("/{id}" + TRAILING_SLASH + "exams")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<ExtExam> getExtExamsByInstitutionId(@NotNull @PathVariable("id") long id, Pageable page){
        return examService.getExtExamsByInstitutionId(id, page);
    }

    @PostMapping("/{id}" + TRAILING_SLASH + "exams")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ExtExam createExam(@NotNull @PathVariable("id") long id, @Valid @NotNull @RequestBody() ExtExam extExam){
        return examService.createExam(id, extExam);
    }

    @GetMapping("/{id}" + TRAILING_SLASH + "exams" + "/{exam_id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ExtExam getExtExamsById(@NotNull @PathVariable("id") long id,
                                         @NotNull @PathVariable("exam_id") long exam_id){
        return examService.getExtExamByIdAndInstitutionId(id, exam_id);
    }

    @PatchMapping("/{id}" + TRAILING_SLASH + "exams" + "/{exam_id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ExtExam updateExam(@NotNull @PathVariable("id") long id,
                              @NotNull @PathVariable("exam_id") long exam_id,
                              @Valid @NotNull @RequestBody() ExtExam extExam){
        return examService.updateExam(id, exam_id, extExam);
    }

    @DeleteMapping("/{id}" + TRAILING_SLASH + "exams" + "/{exam_id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteExam(@NotNull @PathVariable("id") long id,
                           @NotNull @PathVariable("exam_id") long exam_id) {
        examService.deleteExam(exam_id);
    }

}
