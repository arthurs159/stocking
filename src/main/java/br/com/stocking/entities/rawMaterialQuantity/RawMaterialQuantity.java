package br.com.stocking.entities.rawMaterialQuantity;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class RawMaterialQuantity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "rawMaterialId")
    private RawMaterial rawMaterial;

    private int quantity;

    public RawMaterialQuantity() {}

    public RawMaterialQuantity(Product product, RawMaterial rawMaterial, int quantity) {
        this.product = product;
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
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
}
