package br.com.fiap.residex.controller;

import br.com.fiap.residex.dto.cadastro.StatusCadastroDto;
import br.com.fiap.residex.dto.cadastro.StatusUpdateDto;
import br.com.fiap.residex.dto.exibicao.StatusExibicaoDto;
import br.com.fiap.residex.model.Status;
import br.com.fiap.residex.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("/status")
    @ResponseStatus(HttpStatus.CREATED)
    private StatusExibicaoDto create (
            @RequestBody @Valid StatusCadastroDto statusCadastroDto) {
        return statusService.create(statusCadastroDto);
    }

    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    private List<StatusExibicaoDto> findAll() {
        return statusService.findAll();
    }

    @GetMapping("/status/id/{idStatus}")
    @ResponseStatus(HttpStatus.OK)
    private StatusExibicaoDto findById(
            @PathVariable Long idStatus) {
        return statusService.findById(idStatus);
    }

    @GetMapping("/status/descricao/{descricaoStatus}")
    @ResponseStatus(HttpStatus.OK)
    private List<StatusExibicaoDto> findByDescricao(
            @PathVariable String descricaoStatus) {
        return statusService.findByDescricao(descricaoStatus);
    }

    @DeleteMapping("/status/{idStatus}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(
            @PathVariable Long idStatus) {
        statusService.delete(idStatus);
    }

    @PutMapping("/status/{idStatus}")
    @ResponseStatus(HttpStatus.OK)
    private StatusExibicaoDto update(
            @PathVariable Long idStatus,
            @RequestBody StatusUpdateDto statusParam) {
        return statusService.update(idStatus, statusParam);
    }
}
