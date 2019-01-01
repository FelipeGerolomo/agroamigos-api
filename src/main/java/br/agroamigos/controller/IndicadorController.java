package br.agroamigos.controller;


import br.agroamigos.exception.ResourceNotFoundException;
import br.agroamigos.model.Indicador;
import br.agroamigos.payload.ApiResponse;
import br.agroamigos.repository.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IndicadorController {

    @Autowired
    private IndicadorRepository indicadorRepository;

    @GetMapping("/indicadores")
    public Page<Indicador> getAllIndicadores(Pageable pageable) {
        return indicadorRepository.findAll(pageable);
    }

    @GetMapping("/indicador/{indicadorId}")
    public Optional<Indicador> getIndicadoById(@PathVariable Long indicadorId) {
        Indicador indicador = indicadorRepository.findById(indicadorId).orElseThrow(() ->
                new ResourceNotFoundException("Indicador!", "id", indicadorId));
        return indicadorRepository.findById(indicadorId);
    }

    @PostMapping("/indicador")
    public ResponseEntity<?> postIndicador(@Valid @RequestBody Indicador indicador) {

        if (indicadorRepository.existsByIndicador(indicador.getIndicador())) {
            return new ResponseEntity(new ApiResponse(false, "Indicador já existe!"),
                    HttpStatus.BAD_REQUEST);
        }

        Indicador result = indicadorRepository.save(indicador);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/indicador/{indicadorId}")
                .buildAndExpand(result.getIdIndicador()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Indicador criado com sucesso!"));
    }

    @PutMapping("/indicador/{indicadorId}")
    public ResponseEntity<?> updateIndicador(@PathVariable Long indicadorId,
                                             @Valid @RequestBody Indicador indicadorDetails) {

        Indicador indicador = indicadorRepository.findById(indicadorId).orElseThrow(() ->
                new ResourceNotFoundException("Indicador!", "id", indicadorId));

        indicador.setIndicador(indicadorDetails.getIndicador());
        indicador.setUnidade(indicadorDetails.getUnidade());

        Indicador resultUpdate = indicadorRepository.save(indicador);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/indicador/{indicadorId}")
                .buildAndExpand(resultUpdate.getIdIndicador()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Indicador atualizado com sucesso!"));

    }

    @DeleteMapping("/indicador/{indicadorId}")
    public ResponseEntity<?> deleteIndicador(@PathVariable Long indicadorId) {

        Indicador indicador = indicadorRepository.findById(indicadorId).orElseThrow(() ->
                new ResourceNotFoundException("Indicador", "id", indicadorId));

        indicadorRepository.delete(indicador);

        return ResponseEntity.ok()
                .body(new ApiResponse(true, "Indicador removido com sucesso!"));

    }


}
