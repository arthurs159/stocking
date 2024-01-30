package br.com.stocking.entities.product;

import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
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

    private List<RawMaterialQuantity> rawMaterialQuantities = new ArrayList<>();

    public ProductForm() {}

    public ProductForm(Long id, String name, int quantity, List<RawMaterialQuantity> rawMaterialQuantities) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.rawMaterialQuantities = rawMaterialQuantities;
    }

    public Product toEntity() {
        return new Product(this.name, this.quantity);
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

    public List<RawMaterialQuantity> getRawMaterialQuantities() {
        return rawMaterialQuantities;
    }

    public void setRawMaterialQuantities(List<RawMaterialQuantity> rawMaterialQuantities) {
        this.rawMaterialQuantities = rawMaterialQuantities;
    }
}
