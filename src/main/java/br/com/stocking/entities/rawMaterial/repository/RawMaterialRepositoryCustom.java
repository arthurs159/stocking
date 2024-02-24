package br.com.stocking.entities.rawMaterial.repository;

import br.com.stocking.entities.product.productView.ProductDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RawMaterialRepositoryCustom {
    List<ProductDetails> findAllByProductId(Long productId);
}
