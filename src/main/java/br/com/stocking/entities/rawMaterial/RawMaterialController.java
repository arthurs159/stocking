package br.com.stocking.entities.rawMaterial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RawMaterialController {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialController(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @PostMapping("/create/rawMaterial")
    public String createRawMaterial(Model model) {
        return "";
    }

    @GetMapping("/list/rawMaterial")
    public String listRawMaterial(Model model) {
        List<RawMaterial> materialList = rawMaterialRepository.findAll();

        model.addAttribute("materialList", materialList);
        return "";
    }

}
