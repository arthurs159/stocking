package br.com.stocking.entities.rawMaterial;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RawMaterialForm {

    private Long id;
    @NotEmpty(message = "ERRO !!!!!!!!!!!!!!!!!!!!!")
    private String name;
    @NotNull
    private double price;
    @NotNull
    private int quantity;
    private Unit unit;
    private LocalDate expiredDate;

    public RawMaterialForm() {}

    public RawMaterialForm(Long id, String name, double price, int quantity, Unit unit, LocalDate expiredDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.expiredDate = expiredDate;
    }

    public RawMaterial toEntity() {
        return new RawMaterial(this.name, this.price, this.quantity, this.unit, this.expiredDate);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}