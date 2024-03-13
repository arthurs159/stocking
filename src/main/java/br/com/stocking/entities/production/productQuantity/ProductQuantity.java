package br.com.stocking.entities.production.productQuantity;

import br.com.stocking.entities.product.Product;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ProductQuantity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public ProductQuantity() {}

    public ProductQuantity(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
