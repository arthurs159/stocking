package br.com.stocking.entities.rawMaterial;

public class RawMaterialAddForm {
    private Long id;
    private String name;
    private int quantity;

    public RawMaterialAddForm() {}

    public RawMaterialAddForm(Long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public RawMaterialAddForm(RawMaterial rawMaterial) {
        this.id = rawMaterial.getId();
        this.name = rawMaterial.getName();
        this.quantity = rawMaterial.getQuantity();
    }

//    public RawMaterial toEntity(RawMaterial rawMaterial) {
//        return new RawMaterial(this.id, this.name, rawMaterial.getUnitPrice(), rawMaterial.getTotalPrice(), t)
//    }

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
}
