package br.com.stocking.entities.saleItem;

import br.com.stocking.entities.sale.Sale;

public class SaleItemForm {
    private Long id;
    private Sale sale;
    private ItemType itemType;
    private Long itemId;

    public SaleItemForm() {
    }

    public SaleItemForm(Long id, Sale sale, ItemType itemType, Long itemId) {
        this.id = id;
        this.sale = sale;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
