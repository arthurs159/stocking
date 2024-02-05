package br.com.stocking.entities.rawMaterial;

import static org.apache.logging.log4j.util.Strings.isBlank;

public enum Unit {
    GRAMS("g"), KILOGRAMS("kg"),
    MILLILITERS("ml"), LITERS("l"),
    UNIT("un");

    private final String displayName;

    Unit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        if (isBlank(displayName)) return "";
        return displayName;
    }
}
