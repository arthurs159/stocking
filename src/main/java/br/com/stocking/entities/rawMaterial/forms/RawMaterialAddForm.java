package br.com.stocking.entities.rawMaterial.forms;

import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.utils.Unit;
import br.com.stocking.entities.utils.unitCalc.MaterialConverter;

public class RawMaterialAddForm {
    private Long id;
    private Double quantity;
    private Unit unit;
    private double price;

    public RawMaterialAddForm() {}

    public RawMaterialAddForm(Long id, Double quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public RawMaterialAddForm(Long id, Double quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public RawMaterialAddForm(RawMaterial rawMaterial) {
        this.id = rawMaterial.getId();
//        this.quantity = rawMaterial.getQuantity() + convertToMaterialUnit(this.quantity, unit);
    }

    public double materialValueQuantity(Unit unitToAdd) {
        return MaterialConverter.materialValueQuantity(this.quantity, this.unit, unitToAdd);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
