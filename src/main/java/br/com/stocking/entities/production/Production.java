package br.com.stocking.entities.production;

import br.com.stocking.entities.company.Company;
import br.com.stocking.entities.production.productQuantity.ProductQuantity;
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
    private List<ProductQuantity> productQuantities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Production() {
    }

    public void addProductQuantity(ProductQuantity productQuantity) {
        productQuantities.add(productQuantity);
    }

    public void removeProductQuantity(ProductQuantity productQuantity) {
        productQuantities.remove(productQuantity);
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Company getCompany() {
        return company;
    }

    public List<ProductQuantity> getProductQuantities() {
        return productQuantities;
    }
}
