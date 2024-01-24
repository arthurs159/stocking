package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class RawMaterial implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public RawMaterial() {}

    public RawMaterial(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void merge(RawMaterialForm form) {
        this.name = form.getName();
        this.price = form.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }
}
