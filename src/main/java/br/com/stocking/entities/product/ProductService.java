package br.com.stocking.entities.product;


import br.com.stocking.entities.product.repository.ProductRepository;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Product product = productForm.toEntity();

        List<ProductRawMaterial> productRawMaterials = productForm.getRawMaterialQuantities().stream()
                .map(rawMaterialQuantity -> {
                    RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialQuantity.getRawMaterialId())
                            .orElseThrow(() -> new RuntimeException("RawMaterial not found for ID: " + rawMaterialQuantity.getRawMaterialId()));
                    return new ProductRawMaterial(product, rawMaterial, rawMaterialQuantity.getQuantity());
                }).toList();

        productRepository.save(product);
        productRawMaterialRepository.saveAll(productRawMaterials);
    }

//    public int unitPriceCalculator(Product product, RawMaterial rawMaterial) {
//        return 1;
//    }

}
