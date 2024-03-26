package br.com.stocking.entities.rawMaterial;

import br.com.stocking.entities.rawMaterial.forms.RawMaterialAddForm;
import br.com.stocking.entities.rawMaterial.repository.RawMaterialRepository;
import br.com.stocking.entities.utils.Unit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RawMaterialApiController {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialApiController(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping("/compatible/units")
    public ResponseEntity<List<Unit>> loadUnits(@RequestParam(value = "unit") String unit) {
        return ResponseEntity.ok(Unit.getCompatibleUnits(unit));
    }

    @GetMapping("/add/rawMaterial/{rawMaterialId}")
    public ResponseEntity<RawMaterialAddForm> loadAddRawMaterial(@PathVariable("rawMaterialId") Long rawMaterialId) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId).orElseThrow();
        return new ResponseEntity<>(new RawMaterialAddForm(rawMaterial), HttpStatus.OK);
    }

    @PostMapping("/add/rawMaterial/{rawMaterialId}")
    public ResponseEntity<RawMaterialAddForm> AddRawMaterial(@PathVariable("rawMaterialId") Long rawMaterialId, RawMaterialAddForm form) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId).orElseThrow();
        rawMaterial.addNewMaterialQuantity(form.materialValueQuantity(rawMaterial.getUnit()), form.isNewPrice(), form.getUnitPrice(), form.getTotalPrice());
        rawMaterialRepository.save(rawMaterial);

        return new ResponseEntity<>(form, HttpStatus.OK);
    }

}
