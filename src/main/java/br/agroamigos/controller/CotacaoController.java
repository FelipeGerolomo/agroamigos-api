package br.agroamigos.controller;


import br.agroamigos.exception.ResourceNotFoundException;
import br.agroamigos.model.Cotacao;
import br.agroamigos.repository.CotacaoRepository;
import br.agroamigos.repository.IndicadorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "Cotação", description = "Cotação dos indicadores")
public class CotacaoController {
    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private IndicadorRepository indicadorRepository;

    @GetMapping("/indicadores/{indicadorId}/cotacoes")
    public Page<Cotacao> getAllCotacoesByIndicadorId(@PathVariable(value = "indicadorId") Integer indicadorId,
                                                     Pageable pageable) {
        return cotacaoRepository.findByIndicador(indicadorId, pageable);
    }

    @PostMapping("/indicadores/{indicadorId}/cotacoes")
    public Cotacao postCotacao(@PathVariable (value = "indicadorId") Integer indicadorId,
                               @Valid @RequestBody Cotacao cotacao) {
        return indicadorRepository.findById(indicadorId).map(indicador -> {
            cotacao.setIndicador(indicador);
            return cotacaoRepository.save(cotacao);
        }).orElseThrow(()-> new ResourceNotFoundException("Código do Indicador "+ indicadorId + "Não encontrado" ));
    }


}
