package br.agroamigos.controller;


import br.agroamigos.exception.ResourceNotFoundException;
import br.agroamigos.model.Indicador;
import br.agroamigos.repository.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class IndicadorController {
    @Autowired
    private IndicadorRepository indicadorRepository;

    @GetMapping("/indicadores")
    public Page<Indicador> getAllIndicadores(Pageable pageable) {
        return indicadorRepository.findAll(pageable);
    }

    @PostMapping("/indicadores")
    public Indicador postIndicador(@Valid @RequestBody Indicador indicador) {
        return indicadorRepository.save(indicador);
    }

    @PutMapping("/indicadores/{indicadorId}")
    public Indicador updateIndicador(@PathVariable Integer indicadorId, @Valid @RequestBody Indicador postRequest) {
        return indicadorRepository.findById(indicadorId).map(indicador -> {
            indicador.setIndicador(postRequest.getIndicador());
            return indicadorRepository.save(indicador);
        }).orElseThrow(() -> new ResourceNotFoundException("Indicador", "não encontrado", indicadorId));
    }

    @DeleteMapping("/indicadores/{indicadorId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer indicadorId) {
        return indicadorRepository.findById(indicadorId).map(indicador -> {
            indicadorRepository.delete(indicador);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Indicador", "não encontrado", indicadorId));
    }


}
