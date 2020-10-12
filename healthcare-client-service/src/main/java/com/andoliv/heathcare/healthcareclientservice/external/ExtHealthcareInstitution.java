package com.andoliv.heathcare.healthcareclientservice.external;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class ExtHealthcareInstitution {

    private Long id;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String cnpj;

    private long pixeonCoins;

    @JsonIgnore
    private Set<ExtExam> exams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public long getPixeonCoins() {
        return pixeonCoins;
    }

    public void setPixeonCoins(long pixeonCoins) {
        this.pixeonCoins = pixeonCoins;
    }

    public Set<ExtExam> getExams() {
        return exams;
    }

    public void setExams(Set<ExtExam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "ExtHealthcareInstitution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", pixeonCoins=" + pixeonCoins +
                '}';
    }
}
