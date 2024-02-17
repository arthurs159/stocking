package br.com.stocking.entities.company;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;
    private CompanySize companySize;
    private LocalDateTime createdAt;

    public Company() {}

    public Company(Long id, String name, String cnpj, CompanySize companySize, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.companySize = companySize;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CompanySize getCompanySize() {
        return companySize;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
