package br.com.stocking.entities.saleItem;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.sale.Sale;
import jakarta.persistence.*;

@Entity
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Enumerated(EnumType.STRING)
    @Column(name = "itemType")
    private ItemType itemType;

    private Long itemId;

    private int quantity;

    public SaleItem() {}

    public SaleItem(Long id, Sale sale, ItemType itemType, Long itemId, int quantity) {
        this.id = id;
        this.sale = sale;
        this.itemType = itemType;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
