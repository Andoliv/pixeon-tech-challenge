package com.andoliv.healthcare.healthcareservice.controller;

import com.andoliv.healthcare.healthcareservice.external.ExtHealthcareInstitution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to show the IDs of Healthcare Services when Healthcare Client Service call a endpoint "/test"
 *
 * @author anderson.oliveira
 */
@RestController
public class ApplicationController {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping("/test")
    public ExtHealthcareInstitution test() {
        ExtHealthcareInstitution institution = new ExtHealthcareInstitution();
        institution.setName("Healthcare Service ID: " + instanceId);

        return institution;
    }
}
