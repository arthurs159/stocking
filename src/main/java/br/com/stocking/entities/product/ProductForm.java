package br.com.stocking.entities.product;

import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductForm {

    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private int quantity;
    private ProductUnit productUnit;
    private List<RawMaterialQuantity> rawMaterialQuantities = new ArrayList<>();
    private int unitPrice;

    public ProductForm() {}

    public ProductForm(Long id, String name, int quantity, ProductUnit productUnit, List<RawMaterialQuantity> rawMaterialQuantities, int unitPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.productUnit = productUnit;
        this.rawMaterialQuantities = rawMaterialQuantities;
        this.unitPrice = unitPrice;
    }

    public List<Long> getRawMaterialIds() {
        return this.rawMaterialQuantities.stream().map(RawMaterialQuantity::getRawMaterialId).toList();
    }

    public Product toEntity(Double unitPrice) {
        return new Product(this.name, unitPrice);
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductUnit getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    public List<RawMaterialQuantity> getRawMaterialQuantities() {
        return rawMaterialQuantities;
    }

    public void setRawMaterialQuantities(List<RawMaterialQuantity> rawMaterialQuantities) {
        this.rawMaterialQuantities = rawMaterialQuantities;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
