package br.com.stocking.entities.product;

import br.com.stocking.entities.product.productView.ProductViewProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT p.id AS id, p.name AS name, SUM(rm.price * prm.quantity) AS totalPrice
            FROM PRODUCT p
            JOIN PRODUCT_RAW_MATERIAL prm ON p.id = prm.product_id
            JOIN RAW_MATERIAL rm ON rm.id = prm.raw_material_id
            GROUP BY p.id, p.name;
            """, nativeQuery = true)
    List<ProductViewProjection> findAllProductsWithPrice();
}
