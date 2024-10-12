package br.com.fiap.residex.controller;

import br.com.fiap.residex.dto.cadastro.MoradorCadastroDto;
import br.com.fiap.residex.dto.exibicao.MoradorExibicaoDto;
import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping("/morador")
    @ResponseStatus(HttpStatus.CREATED)
    private MoradorExibicaoDto create (
            @RequestBody @Valid MoradorCadastroDto moradorCadastroDto) {
        return moradorService.create(moradorCadastroDto);
    }

    @GetMapping("/morador/{idMorador}")
    @ResponseStatus(HttpStatus.OK)
    private MoradorExibicaoDto readerId(
            @PathVariable Long idMorador) {
        return moradorService.findById(idMorador);
    }

    @DeleteMapping("/morador/{idMorador}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(
            @PathVariable Long idMorador) {
        moradorService.delete(idMorador);
    }
}

