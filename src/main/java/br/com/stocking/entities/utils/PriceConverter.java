package br.com.stocking.entities.utils;

public class PriceConverter {
    public static double convertPriceToDesiredUnit(double pricePerUnit, Unit unitStock, Unit unitDesired) {
        if (unitStock == unitDesired) {
            return pricePerUnit;
        }

        if (unitStock == Unit.KILOGRAMS && unitDesired == Unit.GRAMS) {
            return convertKilogramsToGrams(pricePerUnit);
        }

        if (unitStock == Unit.LITERS && unitDesired == Unit.MILLILITERS) {
            return convertLitersToMilliliters(pricePerUnit);
        }

        return pricePerUnit;
    }

    private static double convertKilogramsToGrams(double pricePerKilogram) {
        return pricePerKilogram / 1000.0;
    }

    private static double convertLitersToMilliliters(double pricePerLiter) {
        return pricePerLiter / 1000.0;
    }
}
