package com.andoliv.healthcare.healthcareservice.model;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class HealthcareInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "healthcareInstitution")
    private Set<Exam> exams;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @CNPJ(message = "CNPJ is invalid")
    @Column(unique = true, nullable = false)
    private String cnpj;

    private int pixeonCoins;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
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

    public int getPixeonCoins() {
        return pixeonCoins;
    }

    public void setPixeonCoins(int pixeonCoins) {
        this.pixeonCoins = pixeonCoins;
    }

    @Override
    public String toString() {
        return "HealthcareInstitution{" +
                "id=" + id +
                ", exams=" + exams +
                ", name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", pixeonCoins=" + pixeonCoins +
                '}';
    }
}
