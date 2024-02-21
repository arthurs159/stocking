package br.com.stocking.entities.rawMaterial.quantity;

import br.com.stocking.entities.rawMaterial.Unit;

public class RawMaterialQuantity {

    private Long rawMaterialId;
    private int quantity;
    private Unit unit;

    public RawMaterialQuantity() {}

    public RawMaterialQuantity(Long rawMaterialId, int quantity, Unit unit) {
        this.rawMaterialId = rawMaterialId;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Long getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(Long rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
