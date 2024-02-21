package br.com.stocking.entities.product;

import br.com.stocking.entities.rawMaterial.*;
import br.com.stocking.entities.rawMaterial.quantity.RawMaterialQuantity;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterial;
import br.com.stocking.entities.rawMaterialQuantity.ProductRawMaterialRepository;
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
    private final ProductRawMaterialRepository productRawMaterialRepository;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, RawMaterialRepository rawMaterialRepository, ProductRawMaterialRepository productRawMaterialRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.productRawMaterialRepository = productRawMaterialRepository;
        this.productService = productService;
    }

    @GetMapping("/product/list")
    public String getProductPage(Model model) {
        model.addAttribute("products", productRepository.findAllProductsWithPrice());
        return "product/list";
    }

    @GetMapping("/product/create")
    public String rawMaterialFormPage(Model model, ProductForm form) {
        List<RawMaterial> rawMaterialList = rawMaterialRepository.findAll();
        model.addAttribute("productForm", form);
        model.addAttribute("unit", Unit.values());
        model.addAttribute("productUnit", ProductUnit.values());
        model.addAttribute("rawMaterialList", rawMaterialList);
        return "product/create";
    }

    @PostMapping("/product/create")
    public String createRawMaterial(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productForm", productForm);
            return "product/create";
        }

        productService.createProductWithRawMaterials(productForm);
        return getProductPage(model);
    }
}
