package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.utils.Unit;

public class RawMaterialAddForm {
    private Long id;
    private Double quantity;
    private Unit unit;

    public RawMaterialAddForm() {}

    public RawMaterialAddForm(Long id, Double quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public RawMaterialAddForm(RawMaterial rawMaterial) {
        this.id = rawMaterial.getId();
//        this.quantity = rawMaterial.getQuantity() + convertToMaterialUnit(this.quantity, unit);
    }

    public double materialValueQuantity(Unit unitToAdd) {
        if (this.unit == unitToAdd) {
            return this.quantity;
        } else if (this.unit == Unit.GRAMS && unitToAdd == Unit.KILOGRAMS) {
            return this.quantity / 1000;
        } else if (this.unit == Unit.KILOGRAMS && unitToAdd == Unit.GRAMS) {
            return this.quantity * 1000;
        } else if (this.unit == Unit.LITERS && unitToAdd == Unit.MILLILITERS) {
            return this.quantity / 1000;
        } else if (this.unit == Unit.MILLILITERS && unitToAdd == Unit.LITERS) {
            return this.quantity * 1000;
        } else {
            throw new IllegalArgumentException("Não é possível adicionar quantidade devido a unidades incompatíveis.");
        }
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
}
