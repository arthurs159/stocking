package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.rawMaterial.validator.NumberValidator;
import br.com.stocking.entities.utils.Unit;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RawMaterialController {

    private final RawMaterialRepository rawMaterialRepository;
    private final NumberValidator numberValidator;

    public RawMaterialController(RawMaterialRepository rawMaterialRepository, NumberValidator numberValidator) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.numberValidator = numberValidator;
    }

    @InitBinder("materialForm")
    public void initBinder(WebDataBinder webDataBinder) { webDataBinder.addValidators(numberValidator); }

    @GetMapping({"/list/rawMaterial", "/"})
    public String listRawMaterial(Model model) {
        List<RawMaterial> materialList = rawMaterialRepository.findAll();

        model.addAttribute("materialList", materialList);
        return "/rawMaterial/list";
    }

    @GetMapping("/create/rawMaterial")
    public String rawMaterialFormPage(Model model, RawMaterialForm form) {
        model.addAttribute("materialForm", form);
        model.addAttribute( "units", Unit.values());
        return "rawMaterial/rawMaterialInsert";
    }

    @PostMapping("/create/rawMaterial")
    public String createRawMaterial(@ModelAttribute("materialForm") @Valid RawMaterialForm materialForm, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("materialForm", materialForm);
            model.addAttribute( "units", Unit.values());
            return "rawMaterial/rawMaterialInsert";
        }

        RawMaterial rawMaterial = materialForm.toEntity();
        rawMaterialRepository.save(rawMaterial);

        return listRawMaterial(model);
    }

    @GetMapping("/update/rawMaterial/{id}")
    public String createRawMaterialForm(@PathVariable Long id, Model model, RawMaterialForm form) {
        Optional<RawMaterial> rawMaterial = rawMaterialRepository.findById(id);
        model.addAttribute( "units", Unit.values());
        rawMaterial.ifPresent(material -> model.addAttribute("material", material));

        return "rawMaterial/updateForm";
    }

    @PostMapping("/update/rawMaterial/{id}")
    public String updateRawMaterial(@PathVariable Long id, @ModelAttribute RawMaterialForm form,  BindingResult result, Model model) {
        if(result.hasErrors()) return createRawMaterialForm(id, model, form);
        RawMaterial rawMaterial = rawMaterialRepository.findById(id).orElseThrow();

        rawMaterial.merge(form);
        rawMaterialRepository.save(rawMaterial);
        return "redirect:/list/rawMaterial";
    }
}
