package br.agroamigos.controller;


import br.agroamigos.exception.ResourceNotFoundException;
import br.agroamigos.model.Cotacao;
import br.agroamigos.payload.ApiResponse;
import br.agroamigos.repository.CotacaoRepository;
import br.agroamigos.repository.IndicadorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CotacaoController {
    @Autowired
    private CotacaoRepository cotacaoRepository;

    @GetMapping("/cotacoes")
    public Page<Cotacao> getAllCotacoes(Pageable pageable) {
        return cotacaoRepository.findAll(pageable);
    }

    @GetMapping("/cotacao/{cotacaoId}")
    public Optional<Cotacao> getIndicadoById(@PathVariable Long cotacaoId) {
        Cotacao indicador = cotacaoRepository.findById(cotacaoId).orElseThrow(() ->
                new ResourceNotFoundException("Cotação!", "id", cotacaoId));
        return cotacaoRepository.findById(cotacaoId);
    }

    @PostMapping("/cotacao")
    public ResponseEntity<?> postCotacoesList(@Valid @RequestBody Set<Cotacao> cotacao) {

        cotacaoRepository.saveAll(cotacao);

        return ResponseEntity.ok()
                .body(new ApiResponse(true, "Cotacão(õs) inseridas com sucesso!"));

    }


}
