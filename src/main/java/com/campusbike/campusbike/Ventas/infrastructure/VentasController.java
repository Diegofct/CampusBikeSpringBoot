package com.campusbike.campusbike.Ventas.infrastructure;

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

import com.campusbike.campusbike.Ventas.application.VentasServiceImpl;
import com.campusbike.campusbike.Ventas.domain.entity.Ventas;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ventas")
public class VentasController {
    
    @Autowired
    private VentasServiceImpl ventasServiceImpl;

    @GetMapping
    public List<Ventas> listAllSales(){
        return ventasServiceImpl.findAll();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @PostMapping
    public ResponseEntity<?> createSale(@Valid @RequestBody Ventas venta, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        ventasServiceImpl.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Venta registrada con exito!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatedSale(@PathVariable Long id, @Valid Ventas updatedVentas, BindingResult result){
        if (result.hasErrors()) {
            return validation(result);
        }
        try {
            Optional<Ventas> existionSaleOptional = ventasServiceImpl.findById(id);
            if(existionSaleOptional.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta con id: " + id + " no fue encontrada.");
            }

            ventasServiceImpl.update(id, updatedVentas);
            return ResponseEntity.ok("Venta actualizada correctamente!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating question: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBike(@PathVariable Long id) {
        try {
            Optional<Ventas> venta = ventasServiceImpl.findAll().stream().filter(s -> s.getId().equals(id)).findFirst();
            if (venta.isPresent()) {
                ventasServiceImpl.delete(venta.get());
                return ResponseEntity.ok("Venta eliminada correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta con id:  " + id + " no fue encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting question: " + e.getMessage());
        }
    }
}
