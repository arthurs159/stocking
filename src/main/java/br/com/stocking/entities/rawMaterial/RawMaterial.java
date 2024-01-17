package br.com.stocking.entities.rawMaterial;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class RawMaterial implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    public RawMaterial() {}

    public RawMaterial(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void merge(RawMaterialForm form) {
        this.name = form.getName();
        this.price = form.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
