package br.com.stocking.entities.product;

import br.com.stocking.entities.rawMaterial.RawMaterial;
import br.com.stocking.entities.rawMaterial.RawMaterialRepository;
import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;

    public ProductController(ProductRepository productRepository, RawMaterialRepository rawMaterialRepository) {
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping("product/list")
    public String getProductPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("product/create")
    public String rawMaterialFormPage(Model model, ProductForm form) {
        List<RawMaterial> rawMaterialList = rawMaterialRepository.findAll();
        model.addAttribute("productForm", form);
        model.addAttribute("rawMaterialList", rawMaterialList);
        return "product/create";
    }

    @PostMapping("product/create")
    public String createRawMaterial(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("productForm", productForm);
            return "product/create";
        }

        List<ProductRawMaterial> productRawMaterials = new ArrayList<>();
        for (RawMaterialQuantity rawMaterialQuantity : productForm.getRawMaterialQuantities()) {
            RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialQuantity.getRawMaterialId()).orElseThrow(() -> new RuntimeException("RawMaterial not found"));
            ProductRawMaterial productRawMaterial = new ProductRawMaterial(productForm.toEntity(), rawMaterial, rawMaterialQuantity.getQuantity());
            productRawMaterials.add(productRawMaterial);
        }

        productForm.setProductRawMaterials(productRawMaterials);
        productRepository.save(productForm.toEntity());
        return getProductPage(model);
    }

}
