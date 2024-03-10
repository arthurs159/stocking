package br.com.stocking.entities.production;

import br.com.stocking.entities.company.Company;
import br.com.stocking.entities.product.Product;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Production implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "production_id")
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Production() {
    }

    public Production(Long id, int quantity, List<Product> products) {
        this.id = id;
        this.quantity = quantity;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Company getCompany() {
        return company;
    }
}
