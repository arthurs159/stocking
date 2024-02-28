package br.com.stocking.entities.sale.salesView;

import br.com.stocking.entities.sale.PaymentMethods;
import br.com.stocking.entities.sale.Sale;

import java.time.LocalDate;

public class SaleView {

    private Long id;
    private Double totalPrice;
    private LocalDate createdAt;
    private PaymentMethods paymentMethod;

    public SaleView() {}

    public SaleView(Long id, Double totalPrice, LocalDate createdAt, PaymentMethods paymentMethod) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.paymentMethod = paymentMethod;
    }

    public SaleView(Sale sale) {
        this.id = sale.getId();
        this.totalPrice = sale.getTotalPrice();
        this.createdAt = sale.getCreatedAt();
        this.paymentMethod = sale.getPaymentMethod();
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
