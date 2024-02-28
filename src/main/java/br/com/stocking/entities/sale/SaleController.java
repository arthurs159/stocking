package br.com.stocking.entities.sale;

import br.com.stocking.entities.sale.salesView.SaleView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SaleController {

    private final SaleRepository saleRepository;

    public SaleController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @GetMapping("/sales")
    public String listSales(Model model) {
        List<SaleView> sales = saleRepository.findAll().stream().map(SaleView::new).toList();

        model.addAttribute("sales", sales);
        return "";
    }
}
