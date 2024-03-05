package br.com.stocking.entities.sale;

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

    public SaleService(SaleRepository saleRepository, SaleItemRepository saleItemRepository, RawMaterialRepository rawMaterialRepository) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    public void saveSale(SaleForm form) {
        Sale sale = new Sale(form.getId(), form.getTotalPrice(), form.getPaymentMethod());
        saleRepository.save(sale);
        List<SaleItem> saleItemList = form.saleItems(form.getSaleItems(), sale);
        saleItemRepository.saveAll(saleItemList);
    }

    public Double calValue(SaleForm form) {
        Map<Long, Integer> rawMaterialIdAndQuantity = form.getRawMaterialIdAndQuantity();
        List<RawMaterial> allMaterial = rawMaterialRepository.findAllByIdIn(rawMaterialIdAndQuantity.keySet().stream().toList());

        return allMaterial.stream()
                .mapToDouble(rawMaterial -> rawMaterial.getPrice() * rawMaterialIdAndQuantity.getOrDefault(rawMaterial.getId(), 0))
                .sum();
    }
}
