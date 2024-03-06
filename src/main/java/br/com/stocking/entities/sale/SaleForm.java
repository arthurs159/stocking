package br.com.stocking.entities.sale;

import br.com.stocking.entities.saleItem.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public SaleForm(Long id, Double totalPrice, PaymentMethods paymentMethod) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public List<SaleItem> saleItems(List<SaleItemForm> forms, Sale sale) {
        return forms.stream().map(saleItem -> toSaleEntity(saleItem, sale)).toList();
    }

    public SaleItem toSaleEntity(SaleItemForm form, Sale sale) {
        return new SaleItem(form.getId(), sale, form.getItemType(), form.getItemId(), form.getQuantity());
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

    public Map<Long, Integer> getRawMaterialIdAndQuantity() {
        return this.getSaleItems().stream()
                .filter(this::isRawMaterial)
                .collect(Collectors.toMap(
                        SaleItemForm::getItemId,
                        SaleItemForm::getQuantity,
                        Integer::sum
                ));
    }

    public Map<Long, Integer> getProductIdAndQuantity() {
        return this.getSaleItems().stream()
                .filter(this::isProduct)
                .collect(Collectors.toMap(
                        SaleItemForm::getItemId,
                        SaleItemForm::getQuantity,
                        Integer::sum
                ));
    }

    private boolean isRawMaterial(SaleItemForm item) {
        return item.getItemType().equals(ItemType.RAW_MATERIAL);
    }

    private boolean isProduct(SaleItemForm item) {
        return item.getItemType().equals(ItemType.PRODUCT);
    }
}
