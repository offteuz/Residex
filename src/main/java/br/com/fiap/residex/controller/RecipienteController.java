package br.com.fiap.residex.controller;

import br.com.fiap.residex.dto.cadastro.RecipienteCadastroDto;
import br.com.fiap.residex.dto.exibicao.RecipienteExibicaoDto;
import br.com.fiap.residex.model.Recipiente;
import br.com.fiap.residex.service.RecipienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipienteController {

    @Autowired
    private RecipienteService recipienteService;

    @PostMapping("/recipiente/{idMorador}")
    @ResponseStatus(HttpStatus.CREATED)
    private RecipienteExibicaoDto create (
            @RequestBody RecipienteCadastroDto recipienteCadastroDto,
            @PathVariable Long idMorador) {
        return recipienteService.create(recipienteCadastroDto, idMorador);
    }

    @GetMapping("/recipiente")
    @ResponseStatus(HttpStatus.OK)
    private List<Recipiente> findAll() {
        return recipienteService.findAll();
    }

    @DeleteMapping("/recipiente/{idRecipiente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(
            @PathVariable Long idRecipiente) {
        recipienteService.delete(idRecipiente);
    }
}
