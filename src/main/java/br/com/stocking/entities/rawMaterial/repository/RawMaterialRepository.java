package br.com.stocking.entities.rawMaterial.repository;

import br.com.stocking.entities.rawMaterial.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    @Query(value = """
        SELECT RM.* FROM PRODUCT_RAW_MATERIAL PRM
            JOIN RAW_MATERIAL RM ON RM.ID = PRM.RAW_MATERIAL_ID
        WHERE PRM.PRODUCT_ID  =  :productId 
    """, nativeQuery = true)
    List<RawMaterial> findAllByProductId(Long productId);
}
