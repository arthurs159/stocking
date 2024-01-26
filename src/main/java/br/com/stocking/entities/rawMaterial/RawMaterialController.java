package br.com.stocking.entities.rawMaterial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RawMaterialController {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialController(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping({"/list/rawMaterial", "/"})
    public String listRawMaterial(Model model) {
        List<RawMaterial> materialList = rawMaterialRepository.findAll();

        model.addAttribute("materialList", materialList);
        return "/rawMaterial/list";
    }

    @GetMapping("/create/rawMaterial")
    public String rawMaterialFormPage(Model model) {
        model.addAttribute("materialForm", new RawMaterialForm());
        return "rawMaterial/rawMaterialInsert";
    }

    @PostMapping("/create/rawMaterial")
    public String createRawMaterial(@ModelAttribute RawMaterialForm materialForm, Model model) {
        RawMaterial rawMaterial = materialForm.toEntity();
        rawMaterialRepository.save(rawMaterial);

        return listRawMaterial(model);
    }

    @GetMapping("/update/rawMaterial/{id}")
    public String createRawMaterialForm(@PathVariable Long id, Model model) {
        Optional<RawMaterial> rawMaterial = rawMaterialRepository.findById(id);

        rawMaterial.ifPresent(material -> model.addAttribute("material", material));

        return "rawMaterial/updateForm";
    }

    @PostMapping("/update/rawMaterial/{id}")
    public String updateRawMaterial(@PathVariable Long id, @ModelAttribute RawMaterialForm form, Model model) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(id).orElseThrow();

        rawMaterial.merge(form);
        rawMaterialRepository.save(rawMaterial);
        return "redirect:/list/rawMaterial";
    }
}
