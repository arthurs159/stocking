package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawMaterialApiController {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialApiController(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping("/add/rawMaterial/{rawMaterialId}")
    public ResponseEntity<RawMaterialAddForm> loadAddRawMaterial(@PathVariable("rawMaterialId") Long rawMaterialId) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId).orElseThrow();
        return new ResponseEntity<>(new RawMaterialAddForm(rawMaterial), HttpStatus.OK);
    }

    @PostMapping("/add/rawMaterial/{rawMaterialId}")
    public ResponseEntity<RawMaterialAddForm> AddRawMaterial(@PathVariable("rawMaterialId") Long rawMaterialId, RawMaterialAddForm form) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId).orElseThrow();
        rawMaterial.addMaterialQuantity(form);
        rawMaterialRepository.save(rawMaterial);

        return new ResponseEntity<>(form, HttpStatus.OK);
    }

}
