package br.com.stocking.entities.rawMaterial.quantity;

public class RawMaterialQuantity {

    private Long rawMaterialId;
    private int quantity;

    public RawMaterialQuantity() {}

    public RawMaterialQuantity(Long rawMaterialId, int quantity) {
        this.rawMaterialId = rawMaterialId;
        this.quantity = quantity;
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
}
