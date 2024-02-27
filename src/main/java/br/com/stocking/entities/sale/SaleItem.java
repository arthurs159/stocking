package br.com.stocking.entities.sale;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import jakarta.persistence.*;

@Entity
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "raw_material_id")
    private RawMaterial rawMaterial;

    public SaleItem() {}

    public SaleItem(Long id, Sale sale, Product product, RawMaterial rawMaterial) {
        this.id = id;
        this.sale = sale;
        this.product = product;
        this.rawMaterial = rawMaterial;
    }

    public Long getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public Product getProduct() {
        return product;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }
}
