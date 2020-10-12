package com.andoliv.heathcare.healthcareclientservice.controller;

import com.andoliv.heathcare.healthcareclientservice.external.ExtExam;
import com.andoliv.heathcare.healthcareclientservice.external.ExtHealthcareInstitution;
import com.andoliv.heathcare.healthcareclientservice.util.RestResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HeathcareController {

    private static final String HTTP_HEALTHCARE_SERVICE = "http://healthcare-service";
    private static final String TEST = "/test";
    private static final String INSTITUTIONS = "/institutions";
    private static final String EXAMS = "/exams";

    private final RestTemplate restTemplate;

    @Autowired
    public HeathcareController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(TEST)
    public ExtHealthcareInstitution test() {
        return restTemplate.getForObject(HTTP_HEALTHCARE_SERVICE + TEST, ExtHealthcareInstitution.class);
    }

    //TODO Fix issue when try get Pages objects.
    @GetMapping(INSTITUTIONS)
    public ResponseEntity<RestResponsePage<ExtHealthcareInstitution>> findAll(Pageable page) {
        String url = HTTP_HEALTHCARE_SERVICE + INSTITUTIONS;

        ParameterizedTypeReference<RestResponsePage<ExtHealthcareInstitution>> responseType = new ParameterizedTypeReference<RestResponsePage<ExtHealthcareInstitution>>() {
        };
        ResponseEntity<RestResponsePage<ExtHealthcareInstitution>> result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);

        return result;
    }

    @GetMapping(INSTITUTIONS + "/{id}" + EXAMS + "/{exam_id}")
    public ExtExam getExtExamsById(@PathVariable("id") long id,
                                   @PathVariable("exam_id") long exam_id) {
        String url = HTTP_HEALTHCARE_SERVICE + INSTITUTIONS + "/{id}" + EXAMS + "/{exam_id}";
        Map<String, Long> urlParams = new HashMap<>();
        urlParams.put("id", id);
        urlParams.put("exam_id", exam_id);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        URI uri = builder.buildAndExpand(urlParams).toUri();

        return restTemplate.getForObject(uri, ExtExam.class);
    }


}
