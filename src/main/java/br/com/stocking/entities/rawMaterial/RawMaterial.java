package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.utils.Unit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDate.now;

@Entity
public class RawMaterial implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private double price;
    private int quantity;
    private Unit unit;
    private final LocalDate createdAt = now();
    private LocalDate expiredDate;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public RawMaterial() {
    }

    public RawMaterial(String name, double price, int quantity, Unit unit, LocalDate expiredDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.expiredDate = expiredDate;
    }

    public void merge(RawMaterialForm form) {
        this.name = form.getName();
        this.price = form.getPrice();
        this.quantity = form.getQuantity();
        this.unit = form.getUnit();
        this.expiredDate = form.getExpiredDate();
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

    public Unit getUnit() {
        return unit;
    }
}
