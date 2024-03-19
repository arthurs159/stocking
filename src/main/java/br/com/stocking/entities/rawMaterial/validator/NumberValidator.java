package br.com.stocking.entities.rawMaterial.validator;

import br.com.stocking.entities.rawMaterial.RawMaterialForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NumberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RawMaterialForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        RawMaterialForm rawMaterialForm = (RawMaterialForm) obj;
//        double unitPrice = rawMaterialForm.getUnitPrice();
//
//        if (!isValidDouble(unitPrice)) {
//            errors.rejectValue("unitPrice", "invalid.number", "O preço por unidade deve ser um número válido");
//        }
    }

    private boolean isValidDouble(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }
}
