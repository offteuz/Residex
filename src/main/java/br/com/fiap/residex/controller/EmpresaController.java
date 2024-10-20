package br.com.fiap.residex.controller;

import br.com.fiap.residex.dto.cadastro.EmpresaCadastroDto;
import br.com.fiap.residex.dto.cadastro.EmpresaUpdateDto;
import br.com.fiap.residex.dto.exibicao.EmpresaExibicaoDto;
import br.com.fiap.residex.dto.exibicao.EmpresaSemCaminhoesExibicaoDto;
import br.com.fiap.residex.model.Empresa;
import br.com.fiap.residex.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    private EmpresaSemCaminhoesExibicaoDto create(
            @RequestBody @Valid EmpresaCadastroDto empresaCadastroDto) {
        return empresaService.create(empresaCadastroDto);
    }

    @GetMapping("/empresa")
    @ResponseStatus(HttpStatus.OK)
    private List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @DeleteMapping("/empresa/{idEmpresa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(
            @PathVariable Long idEmpresa) {
        empresaService.delete(idEmpresa);
    }

    @PutMapping("/empresa/{idEmpresa}")
    @ResponseStatus(HttpStatus.OK)
    private EmpresaExibicaoDto update(
            @PathVariable Long idEmpresa,
            @RequestBody EmpresaUpdateDto empresaUpdateDto) {
        return empresaService.update(idEmpresa, empresaUpdateDto);
    }
}
