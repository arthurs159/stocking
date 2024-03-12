package br.com.stocking.entities.product;


import br.com.stocking.entities.product.repository.ProductRepository;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterialRepository;
import br.com.stocking.entities.utils.PriceConverter;
import br.com.stocking.entities.utils.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final ProductRawMaterialRepository productRawMaterialRepository;


    public ProductService(ProductRepository productRepository, RawMaterialRepository rawMaterialRepository, ProductRawMaterialRepository productRawMaterialRepository) {
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.productRawMaterialRepository = productRawMaterialRepository;
    }

    public void createProductWithRawMaterials(ProductForm productForm) {
        if (isNull(productForm)) return;
        Product product = productForm.toEntity(calcProductPrices(productForm));

        List<ProductRawMaterial> productRawMaterials = productForm.getRawMaterialQuantities().stream()
                .map(rawMaterialQuantity -> {
                    RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialQuantity.getRawMaterialId())
                            .orElseThrow(() -> new RuntimeException("RawMaterial not found for ID: " + rawMaterialQuantity.getRawMaterialId()));
                    return new ProductRawMaterial(product, rawMaterial, rawMaterialQuantity.getQuantity(), rawMaterialQuantity.getUnit());
                }).toList();

        productRepository.save(product);
        productRawMaterialRepository.saveAll(productRawMaterials);
    }

    private double calcProductPrices(ProductForm form) {
        List<RawMaterial> rawMaterials = rawMaterialRepository.findAllByIdIn(form.getRawMaterialIds());

        double totalPrice = 0.0;

        for (RawMaterial rawMaterial : rawMaterials) {
            Optional<RawMaterialQuantity> optionalQuantity = form.getRawMaterialQuantities().stream()
                    .filter(rm -> rm.getRawMaterialId().equals(rawMaterial.getId()))
                    .findFirst();

            if (optionalQuantity.isPresent()) {
                double quantityDesired = optionalQuantity.get().getQuantity();
                Unit unitDesired = optionalQuantity.get().getUnit();
                double pricePerUnit = rawMaterial.getPrice();
                Unit unitStock = rawMaterial.getUnit();

                double materialCost = calculateCost(quantityDesired, pricePerUnit, unitStock, unitDesired);
                totalPrice += materialCost;
            }
        }

        return totalPrice;
    }

    public double calculateCost(double quantityDesired, double pricePerUnit, Unit unitStock, Unit unitDesired) {
        double pricePerUnitInDesiredUnit = convertPriceToDesiredUnit(pricePerUnit, unitStock, unitDesired);
        return pricePerUnitInDesiredUnit * quantityDesired;
    }

    private double convertPriceToDesiredUnit(double pricePerUnit, Unit unitStock, Unit unitDesired) {
        if (unitStock == unitDesired) {
            return pricePerUnit;
        }

        if (unitStock == Unit.KILOGRAMS && unitDesired == Unit.GRAMS) {
            return pricePerUnit / 1000.0;
        }

        if (unitStock == Unit.LITERS && unitDesired == Unit.MILLILITERS) {
            return pricePerUnit / 1000.0;
        }

        return pricePerUnit;
    }

}
