package br.com.stocking.entities.sale;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.saleItem.SaleItem;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDate.now;

@Entity
public class Sale implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Double TotalPrice;
    private final LocalDate createdAt = now();
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> saleItems;

    public Sale() {}

    public Sale(Long id, Double totalPrice, PaymentMethods paymentMethod, List<SaleItem> saleItems) {
        this.id = id;
        TotalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.saleItems = saleItems;
    }

    public Long getId() {
        return id;
    }

    public Double getTotalPrice() {
        return TotalPrice;
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
