package br.com.stocking.entities.expenses;

import br.com.stocking.entities.expenses.view.ExpensesView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpensesController {

    private final ExpensesRepository expensesRepository;

    public ExpensesController(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }


    @GetMapping("/expenses")
    public String listSales(Model model) {
        List<ExpensesView> expenses = expensesRepository.findAll().stream().map(ExpensesView::new).toList();

        model.addAttribute("sales", expenses);
        return "";
    }
}
