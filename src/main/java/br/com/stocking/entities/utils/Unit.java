package br.com.stocking.entities.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static Unit fromString(String unitString) {
        return Arrays.stream(values())
                .filter(unit -> unit.toString().equals(unitString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unidade inválida: " + unitString));
    }

    public static List<Unit> getCompatibleUnits(String compatibleUnit) {
        List<Unit> compatibleUnits = new ArrayList<>();
        Unit unit = fromString(compatibleUnit);
        switch (unit) {
            case GRAMS, KILOGRAMS:
                compatibleUnits.add(GRAMS);
                compatibleUnits.add(KILOGRAMS);
                break;
            case MILLILITERS, LITERS:
                compatibleUnits.add(MILLILITERS);
                compatibleUnits.add(LITERS);
                break;
            case UNIT:
                compatibleUnits.add(UNIT);
                break;
            default:
                break;
        }
        return compatibleUnits;
    }
}
