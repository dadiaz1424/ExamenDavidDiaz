package ec.edu.espe.arquitectura.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.model.OfiEdificio;
import ec.edu.espe.arquitectura.examen.service.OfiEdificioService;

@RestController
@RequestMapping("/api/v1/edificio")
public class OfiEdificioController {

    private final OfiEdificioService ofiEdificioService;

    public OfiEdificioController(OfiEdificioService ofiEdificioService) {
        this.ofiEdificioService = ofiEdificioService;
    }

    @PostMapping
    public ResponseEntity<OfiEdificio> create(@RequestBody OfiEdificio ofiEdificio) {
        try {
            OfiEdificio edificioRS = this.ofiEdificioService.create(ofiEdificio);
            return ResponseEntity.ok(edificioRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }

    }

    

    
}
