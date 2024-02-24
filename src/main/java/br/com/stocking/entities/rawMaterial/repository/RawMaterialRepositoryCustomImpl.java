package br.com.stocking.entities.rawMaterial.repository;

import br.com.stocking.entities.product.productView.ProductDetails;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.transform.Transformers.aliasToBean;

@Repository
public class RawMaterialRepositoryCustomImpl implements RawMaterialRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public RawMaterialRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    String ALL_MATERIAL_DETAILS = """
    SELECT RM.*, PRM.QUANTITY AS quantityUsed FROM PRODUCT_RAW_MATERIAL PRM
    JOIN RAW_MATERIAL RM ON RM.ID = PRM.RAW_MATERIAL_ID
    WHERE PRM.PRODUCT_ID = :productId
    """;

    @Override
    public List<ProductDetails> findAllByProductId(Long productId) {
        return entityManager.unwrap(Session.class)
                .createNativeQuery(ALL_MATERIAL_DETAILS)
                .setParameter("productId", productId)
                .addEntity("rawMaterials", RawMaterial.class)
                .addScalar("quantityUsed", StandardBasicTypes.DOUBLE)
                .setResultTransformer(aliasToBean(ProductDetails.class))
                .getResultList();
    }
}
