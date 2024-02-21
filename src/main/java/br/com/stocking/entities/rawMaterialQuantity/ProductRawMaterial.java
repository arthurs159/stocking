package br.com.stocking.entities.rawMaterialQuantity;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.Unit;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class ProductRawMaterial implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rawMaterialId")
    private RawMaterial rawMaterial;

    private int quantity;

    private Unit unit;

    public ProductRawMaterial() {}

    public ProductRawMaterial(Product product, RawMaterial rawMaterial, int quantity) {
        this.product = product;
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
    }

    public ProductRawMaterial(Long id, Product product, RawMaterial rawMaterial, int quantity, Unit unit) {
        this.id = id;
        this.product = product;
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public int getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }
}
