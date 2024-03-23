package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.utils.Unit;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

public class RawMaterialForm {

    private Long id;
    @NotEmpty(message = "ERRO !!!!!!!!!!!!!!!!!!!!!")
    private String name;
    @NotNull(message = "Não pode ser vazio")
    private Double unitPrice;
    @NotNull(message = "Não pode ser vazio")
    private Double totalPrice;
    private Double quantity = 0.0;
    private Unit unit;
    private LocalDate expiredDate;

    public RawMaterialForm() {}

    public RawMaterialForm(String name, Double unitPrice, Double totalPrice, Double quantity, Unit unit, LocalDate expiredDate) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.unit = unit;
        this.expiredDate = expiredDate;
    }

    public RawMaterial toEntity() {
        return new RawMaterial(this.name, this.unitPrice, this.totalPrice, this.quantity, this.unit, this.expiredDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }
}