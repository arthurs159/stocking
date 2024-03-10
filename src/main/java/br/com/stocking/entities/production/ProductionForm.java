package br.com.stocking.entities.production;

import br.com.stocking.entities.company.Company;
import br.com.stocking.entities.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductionForm {

    private Long id;
    private int quantity;
    private List<Product> products = new ArrayList<>();
    private Company company;

    public ProductionForm() {
    }

    public ProductionForm(Long id, int quantity, List<Product> products, Company company) {
        this.id = id;
        this.quantity = quantity;
        this.products = products;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
