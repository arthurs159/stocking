package br.com.stocking.entities.sale;

import br.com.stocking.entities.saleItem.SaleItem;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDate.now;

@Entity
public class Sale implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Double totalPrice;
    private final LocalDate createdAt = now();
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> saleItems;

    public Sale() {}

    public Sale(Long id, Double totalPrice, PaymentMethods paymentMethod) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }
}
