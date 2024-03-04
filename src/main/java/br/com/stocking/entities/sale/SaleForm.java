package br.com.stocking.entities.sale;

import br.com.stocking.entities.saleItem.SaleItem;
import br.com.stocking.entities.saleItem.SaleItemForm;

import java.util.List;

public class SaleForm {
    private Long id;
    private Double totalPrice;
    private PaymentMethods paymentMethod;
    private List<SaleItemForm> saleItems;

    public SaleForm() {}

    public SaleForm(Long id, Double totalPrice, PaymentMethods paymentMethod, List<SaleItemForm> saleItems) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.saleItems = saleItems;
    }

    public Sale toEntity() {
        return new Sale(this.getId(), this.getTotalPrice(), this.getPaymentMethod(), saleConverter(this.saleItems));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<SaleItemForm> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItemForm> saleItems) {
        this.saleItems = saleItems;
    }

    public List<SaleItem> saleConverter(List<SaleItemForm> forms) {
        return forms.stream()
                .map(this::toSaleEntity).toList();
    }

    public SaleItem toSaleEntity(SaleItemForm form) {
        return new SaleItem(form.getId(), form.getSale(), form.getItemType(), form.getItemId());
    }
}
