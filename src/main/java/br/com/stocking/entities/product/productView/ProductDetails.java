package br.com.stocking.entities.product.productView;

import br.com.stocking.entities.rawMaterial.RawMaterial;

public class ProductDetails {
    private RawMaterial rawMaterials;
    private Double quantityUsed;

    public ProductDetails() {}

    public ProductDetails(RawMaterial rawMaterials, Double quantityUsed) {
        this.rawMaterials = rawMaterials;
        this.quantityUsed = quantityUsed;
    }

    public RawMaterial getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(RawMaterial rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public Double getQuantity() {
        return quantityUsed;
    }

    public void setQuantity(Double quantityUsed) {
        this.quantityUsed = quantityUsed;
    }
}
