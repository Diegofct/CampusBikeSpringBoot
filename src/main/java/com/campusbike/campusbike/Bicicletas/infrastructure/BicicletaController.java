package com.campusbike.campusbike.Bicicletas.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.campusbike.Bicicletas.application.BicicletaServiceImpl;
import com.campusbike.campusbike.Bicicletas.domain.entity.Bicicletas;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {

    @Autowired
    private BicicletaServiceImpl bicicletaServiceImpl;

    @GetMapping
    public List<Bicicletas> listAllBikes(){
        return bicicletaServiceImpl.findAll();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @PostMapping
    public ResponseEntity<?> createBike(@Valid @RequestBody Bicicletas bicicleta, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        bicicletaServiceImpl.save(bicicleta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bicicleta registrada con exito!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatedBike(@PathVariable Long id, @Valid Bicicletas updatedBicicleta, BindingResult result){
        if (result.hasErrors()) {
            return validation(result);
        }
        try {
            Optional<Bicicletas> existionBikeOptional = bicicletaServiceImpl.findById(id);
            if(existionBikeOptional.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bicicleta con id: " + id + " no fue encontrada.");
            }

            bicicletaServiceImpl.update(id, updatedBicicleta);
            return ResponseEntity.ok("Bicicleta actualizada correctamente!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating question: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBike(@PathVariable Long id) {
        try {
            Optional<Bicicletas> bicicleta = bicicletaServiceImpl.findAll().stream().filter(s -> s.getId().equals(id)).findFirst();
            if (bicicleta.isPresent()) {
                bicicletaServiceImpl.delete(bicicleta.get());
                return ResponseEntity.ok("Bicicleta eliminada correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bicicleta con id:  " + id + " no fue encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting question: " + e.getMessage());
        }
    }
}
