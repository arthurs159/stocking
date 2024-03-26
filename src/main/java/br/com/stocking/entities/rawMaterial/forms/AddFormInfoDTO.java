package br.com.stocking.entities.rawMaterial.forms;

import br.com.stocking.entities.rawMaterial.RawMaterial;

public class AddFormInfoDTO {

    private Long id;
    private double unitPrice;
    private double totalPrice;

    public AddFormInfoDTO() {}

    public AddFormInfoDTO(Long id, double unitPrice, double totalPrice) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
