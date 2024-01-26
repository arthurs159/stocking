package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.*;
import static java.time.LocalDate.*;

@Entity
public class RawMaterial implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private double price;
    private int quantity;
    private LocalDate createdAt = now();
    private LocalDate expiredDate;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public RawMaterial() {}

    public RawMaterial(String name, double price, int quantity, LocalDate expiredDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiredDate = expiredDate;
//        this.product = product;
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

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }
}
