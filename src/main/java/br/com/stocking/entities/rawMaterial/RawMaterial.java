package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.forms.RawMaterialForm;
import br.com.stocking.entities.utils.Unit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
    private Double unitPrice;
    @NotNull
    private Double totalPrice;
    private Double quantity;
    private Unit unit;
    private final LocalDate createdAt = now();
    private LocalDate expiredDate;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public RawMaterial() {}

    public RawMaterial(Long id, String name, double unitPrice, double totalPrice, Double quantity, Unit unit, LocalDate expiredDate) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.unit = unit;
        this.expiredDate = expiredDate;
    }

    public RawMaterial(String name, double unitPrice, double totalPrice, Double quantity, Unit unit, LocalDate expiredDate) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.unit = unit;
        this.expiredDate = expiredDate;
    }

    public void merge(RawMaterialForm form) {
        this.name = form.getName();
        this.unitPrice = form.getUnitPrice();
        this.totalPrice = form.getTotalPrice();
        this.quantity = form.getQuantity();
        this.unit = form.getUnit();
        this.expiredDate = form.getExpiredDate();
    }

    public void addNewMaterialQuantity(double quantity, boolean isNewPrice, Double unitPrice, Double totalPrice) {
        double totalQuantity = this.quantity + quantity;
        if (isNewPrice) this.unitPrice = calculateAverageUnitPrice(this.quantity, this.unitPrice, quantity, unitPrice);
        else this.unitPrice += unitPrice;
        this.quantity = totalQuantity;
        this.totalPrice += totalPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    private double calculateAverageUnitPrice(double existingQuantity, double existingUnitPrice, double newQuantity, double newUnitPrice) {
        double totalQuantity = existingQuantity + newQuantity;
        return ((existingQuantity * existingUnitPrice) + (newQuantity * newUnitPrice)) / totalQuantity;
    }

}
