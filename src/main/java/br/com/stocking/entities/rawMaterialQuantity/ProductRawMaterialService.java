package br.com.stocking.entities.rawMaterialQuantity;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import org.springframework.stereotype.Service;

@Service
public class ProductRawMaterialService {

    private final ProductRawMaterialRepository productRawMaterialRepository;

    public ProductRawMaterialService(ProductRawMaterialRepository productRawMaterialRepository) {
        this.productRawMaterialRepository = productRawMaterialRepository;
    }

    public void createQuantityRawMaterialForProduct(RawMaterial rawMaterial, Product product, int quantity) {
        ProductRawMaterial productRawMaterial = new ProductRawMaterial(product, rawMaterial, quantity);

        productRawMaterialRepository.save(productRawMaterial);
    }
}
