package br.com.stocking.entities.rawMaterial;

import java.time.LocalDate;

public class RawMaterialForm {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private LocalDate expiredDate;

    public RawMaterialForm() {}

    public RawMaterialForm(Long id, String name, double price, int quantity, LocalDate expiredDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiredDate = expiredDate;
    }

    public RawMaterial toEntity() {
        return new RawMaterial(this.name, this.price, this.quantity, this.expiredDate);
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
}