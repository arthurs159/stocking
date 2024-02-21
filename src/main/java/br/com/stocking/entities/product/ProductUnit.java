package br.com.stocking.entities.product;

import static org.apache.logging.log4j.util.Strings.isBlank;

public enum ProductUnit {
    UNIT("Unidade"),
    KG("Kilo"),
    L("Litros");

    private final String displayName;

    ProductUnit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        if (isBlank(displayName)) return "";
        return displayName;
    }
}
