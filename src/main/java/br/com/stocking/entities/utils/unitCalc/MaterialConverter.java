package br.com.stocking.entities.utils.unitCalc;

import br.com.stocking.entities.utils.Unit;

import java.util.HashMap;
import java.util.Map;

public class MaterialConverter {
    private static final Map<UnitPair, Double> CONVERSION_MAP = new HashMap<>();

    static {
        CONVERSION_MAP.put(new UnitPair(Unit.GRAMS, Unit.KILOGRAMS), 1.0 / 1000);
        CONVERSION_MAP.put(new UnitPair(Unit.KILOGRAMS, Unit.GRAMS), 1000.0);
        CONVERSION_MAP.put(new UnitPair(Unit.LITERS, Unit.MILLILITERS), 1000.0);
        CONVERSION_MAP.put(new UnitPair(Unit.MILLILITERS, Unit.LITERS), 1.0 / 1000);
    }

    public static double materialValueQuantity(double quantity, Unit sourceUnit, Unit targetUnit) {
        if (sourceUnit == targetUnit) return quantity;
        Double conversionFactor = CONVERSION_MAP.get(new UnitPair(sourceUnit, targetUnit));
        if (conversionFactor == null) throw new IllegalArgumentException("Não é possível converter entre as unidades fornecidas.");
        return quantity * conversionFactor;
    }
}
