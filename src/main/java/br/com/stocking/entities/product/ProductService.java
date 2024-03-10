package br.com.stocking.entities.product;


import br.com.stocking.entities.product.repository.ProductRepository;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.Unit;
import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterialRepository;
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
        Product product = productForm.toEntity(calcProductPrice(productForm));

        List<ProductRawMaterial> productRawMaterials = productForm.getRawMaterialQuantities().stream()
                .map(rawMaterialQuantity -> {
                    RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialQuantity.getRawMaterialId())
                            .orElseThrow(() -> new RuntimeException("RawMaterial not found for ID: " + rawMaterialQuantity.getRawMaterialId()));
                    return new ProductRawMaterial(product, rawMaterial, rawMaterialQuantity.getQuantity());
                }).toList();

        productRepository.save(product);
        productRawMaterialRepository.saveAll(productRawMaterials);
    }

    private double calcProductPrice(ProductForm form) {

        List<RawMaterial> rawMaterials = rawMaterialRepository.findAllByIdIn(form.getRawMaterialIds());

        return rawMaterials.stream()
                .mapToDouble(RawMaterial::getPrice)
                .sum();
    }

    private double calcProductPrices(ProductForm form) {
        RawMaterialQuantity rawMaterialQuantity = new RawMaterialQuantity();

        List<RawMaterial> rawMaterials = rawMaterialRepository.findAllByIdIn(form.getRawMaterialIds());

        double totalPrice = 0.0;

        for (RawMaterial rawMaterial : rawMaterials) {
            Optional<RawMaterialQuantity> optionalQuantity = form.getRawMaterialQuantities().stream()
                    .filter(rm -> rm.getRawMaterialId().equals(rawMaterial.getId()))
                    .findFirst();

            if (optionalQuantity.isPresent()) {
                double quantity = optionalQuantity.get().getQuantity();
                Unit unit = optionalQuantity.get().getUnit();

                double materialCost = calculateMaterialCost(rawMaterial.getPrice(), quantity, unit);
                totalPrice += materialCost;
            }
        }

        return totalPrice;
    }

    private double calculateMaterialCost(double pricePerUnit, double quantity, Unit unit) {
        return pricePerUnit * quantity;
    }

}
