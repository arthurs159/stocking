package br.com.stocking.entities.rawMaterial;

public class RawMaterialForm {

    private Long id;
    private String name;
    private double price;

    public RawMaterialForm() {}

    public RawMaterialForm(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public RawMaterial toEntity() {
        return new RawMaterial(this.name, this.price);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
