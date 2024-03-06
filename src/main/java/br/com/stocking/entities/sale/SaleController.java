package br.com.stocking.entities.sale;

import br.com.stocking.entities.product.repository.ProductRepository;
import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.sale.salesView.SaleView;
import br.com.stocking.entities.saleItem.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SaleController {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final SaleItemRepository saleItemRepository;
    private final SaleService saleService;

    public SaleController(SaleRepository saleRepository, ProductRepository productRepository, RawMaterialRepository rawMaterialRepository, SaleItemRepository saleItemRepository, SaleService saleService) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.saleItemRepository = saleItemRepository;
        this.saleService = saleService;
    }

    @GetMapping("/sales")
    public String listSales(Model model) {
        List<SaleView> sales = saleRepository.findAll().stream().map(SaleView::new).toList();

        model.addAttribute("sales", sales);
        return "sales/list";
    }

    @GetMapping("/sales/create")
    public String getSaleForm(Model model, SaleForm form) {
        model.addAttribute("saleForm", form);
        model.addAttribute("payMethod", PaymentMethods.values());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("rawMaterials", rawMaterialRepository.findAll());
        return "sales/create";
    }

    @PostMapping(value = "/sales/create")
    public String createNewSale(@RequestBody SaleForm saleForm, BindingResult result, Model model) {
        if (result.hasErrors()) return "sales/create";
        saleService.saveSale(saleForm);
        return "sales/list";
    }
}
