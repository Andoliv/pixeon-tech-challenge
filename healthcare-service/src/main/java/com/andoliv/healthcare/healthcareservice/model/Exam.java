package com.andoliv.healthcare.healthcareservice.model;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "healthcare_institution_id", referencedColumnName = "id")
    private HealthcareInstitution healthcareInstitution;

    private String patientName;

    private Integer patientAge;

    @Enumerated(STRING)
    private Gender patientGender;

    private String physicianName;

    @Column(name = "physician_crm")
    private Integer physicianCRM;

    private String procedureName;

    @Column(columnDefinition = "boolean default false")
    private boolean examRetrieved;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HealthcareInstitution getHealthcareInstitution() {
        return healthcareInstitution;
    }

    public void setHealthcareInstitution(HealthcareInstitution healthcareInstitution) {
        this.healthcareInstitution = healthcareInstitution;
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

    public boolean isExamRetrieved() {
        return examRetrieved;
    }

    public void setExamRetrieved(boolean examRetrieved) {
        this.examRetrieved = examRetrieved;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", healthcareInstitution=" + healthcareInstitution +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender=" + patientGender +
                ", physicianName='" + physicianName + '\'' +
                ", physicianCRM=" + physicianCRM +
                ", procedureName='" + procedureName + '\'' +
                ", examRetrieved=" + examRetrieved +
                '}';
    }
}
