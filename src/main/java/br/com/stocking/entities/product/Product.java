package br.com.stocking.entities.product;

import br.com.stocking.entities.rawMaterial.RawMaterial;
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RawMaterial> rawMaterialList = new ArrayList<>();

    public Product() {}

    public Product(Long id, String name, int quantity, List<RawMaterial> rawMaterialList) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.rawMaterialList = rawMaterialList;
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

    public List<RawMaterial> getRawMaterialList() {
        return rawMaterialList;
    }
}
