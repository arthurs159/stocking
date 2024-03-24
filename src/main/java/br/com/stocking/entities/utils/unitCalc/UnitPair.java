package br.com.stocking.entities.utils.unitCalc;

import br.com.stocking.entities.utils.Unit;

public class UnitPair {
    private final Unit sourceUnit;
    private final Unit targetUnit;

    public UnitPair(Unit sourceUnit, Unit targetUnit) {
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UnitPair unitPair = (UnitPair) obj;
        return sourceUnit == unitPair.sourceUnit && targetUnit == unitPair.targetUnit;
    }

    @Override
    public int hashCode() {
        return 31 * sourceUnit.hashCode() + targetUnit.hashCode();
    }
}
