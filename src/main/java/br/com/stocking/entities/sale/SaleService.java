package br.com.stocking.entities.sale;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.product.repository.ProductRepository;
import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.saleItem.SaleItem;
import br.com.stocking.entities.saleItem.SaleItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository, SaleItemRepository saleItemRepository, RawMaterialRepository rawMaterialRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.productRepository = productRepository;
    }

    public void saveSale(SaleForm form) {
        Sale sale = new Sale(form.getId(), calcValue(form), form.getPaymentMethod());
        saleRepository.save(sale);
        List<SaleItem> saleItemList = form.saleItems(form.getSaleItems(), sale);
        saleItemRepository.saveAll(saleItemList);
    }

    public Double calcValue(SaleForm form) {
        Map<Long, Integer> rawMaterialIdAndQuantity = form.getRawMaterialIdAndQuantity();
        Map<Long, Integer> productIdAndQuantity = form.getProductIdAndQuantity();
        List<RawMaterial> allMaterial = rawMaterialRepository.findAllByIdIn(rawMaterialIdAndQuantity.keySet().stream().toList());
        List<Product> allProduct = productRepository.findAllByIdIn(productIdAndQuantity.keySet().stream().toList());

        double sumMaterial = allMaterial.stream()
                .mapToDouble(rawMaterial -> rawMaterial.getPrice() * rawMaterialIdAndQuantity.getOrDefault(rawMaterial.getId(), 0))
                .sum();

        double sumProductPrice = allProduct.stream()
                .mapToDouble(product -> product.getUnitPrice() * productIdAndQuantity.getOrDefault(product.getId(), 0))
                .sum();

        return sumMaterial + sumProductPrice + form.getTotalPrice();
    }
}
