package br.com.stocking.entities.production;

import br.com.stocking.entities.product.Product;
import br.com.stocking.entities.product.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductionController {

    private final ProductRepository productRepository;

    public ProductionController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/production")
    private String production(Model model) {
        List<Product> products = productRepository.findAll();

        model.addAttribute("products", products);
        return "production/production";
    }
}
