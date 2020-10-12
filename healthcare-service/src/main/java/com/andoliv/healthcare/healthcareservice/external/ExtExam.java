package com.andoliv.healthcare.healthcareservice.external;

import com.andoliv.healthcare.healthcareservice.model.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExtExam {

    private long id;
    @JsonIgnore
    private ExtHealthcareInstitution institution;
    private String patientName;
    private Integer patientAge;
    private Gender patientGender;
    private String physicianName;
    private Integer physicianCRM;
    private String procedureName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExtHealthcareInstitution getInstitution() {
        return institution;
    }

    public void setInstitution(ExtHealthcareInstitution institution) {
        this.institution = institution;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public Integer getPhysicianCRM() {
        return physicianCRM;
    }

    public void setPhysicianCRM(Integer physicianCRM) {
        this.physicianCRM = physicianCRM;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    @Override
    public String toString() {
        return "ExtExam{" +
                "id=" + id +
                ", healthcareInstitution=" + institution +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender=" + patientGender +
                ", physicianName='" + physicianName + '\'' +
                ", physicianCRM=" + physicianCRM +
                ", procedureName='" + procedureName + '\'' +
                '}';
    }
}
