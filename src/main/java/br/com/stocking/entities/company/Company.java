package br.com.stocking.entities.company;

import br.com.stocking.entities.production.Production;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;
    private CompanySize companySize;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Production> productions = new ArrayList<>();

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

    public List<Production> getProductions() {
        return productions;
    }
}
