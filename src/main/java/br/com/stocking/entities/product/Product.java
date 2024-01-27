package br.com.stocking.entities.product;

import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RawMaterial> rawMaterialList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductRawMaterial> productRawMaterials = new ArrayList<>();

    public Product() {}

    public Product(String name, int quantity, List<ProductRawMaterial> productRawMaterials) {
        this.name = name;
        this.quantity = quantity;
        this.productRawMaterials = productRawMaterials;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<ProductRawMaterial> getProductRawMaterials() {
        return productRawMaterials;
    }
}
