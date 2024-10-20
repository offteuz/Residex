package br.com.fiap.residex.controller;

import br.com.fiap.residex.dto.cadastro.CaminhaoCadastroDto;
import br.com.fiap.residex.dto.exibicao.CaminhaoExibicaoDto;
import br.com.fiap.residex.dto.exibicao.CaminhaoRastreioDto;
import br.com.fiap.residex.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhao")
    @ResponseStatus(HttpStatus.CREATED)
    private CaminhaoExibicaoDto create (
            @RequestBody @Valid CaminhaoCadastroDto caminhaoCadastroDto) {
        return caminhaoService.create(caminhaoCadastroDto);
    }

    @GetMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    private List<CaminhaoExibicaoDto> findAll() {
        return caminhaoService.findAll();
    }

//    @GetMapping("/caminhao/status/{status}")
//    @ResponseStatus(HttpStatus.OK)
//    private List<CaminhaoRastreioDto> findByStatus(
//            @PathVariable String status) {
//        return caminhaoService.findByStatus(status);
//    }

    @GetMapping("/caminhao/id/{idCaminhao}")
    @ResponseStatus(HttpStatus.OK)
    private CaminhaoRastreioDto findById(
            @PathVariable Long idCaminhao) {
        return caminhaoService.findById(idCaminhao);
    }

    @PutMapping("/caminhao/coletar/{idRecipiente}/{idCaminhao}")
    @ResponseStatus(HttpStatus.OK)
    private CaminhaoExibicaoDto sairParaColeta (
            @PathVariable Long idRecipiente,
            @PathVariable Long idCaminhao) {
        return caminhaoService.sairParaColeta(idRecipiente, idCaminhao);
    }

    @PatchMapping("/caminhao/retornar/{idEmpresa}/{idCaminhao}")
    @ResponseStatus(HttpStatus.OK)
    private CaminhaoExibicaoDto retornarColeta (
            @PathVariable Long idEmpresa,
            @PathVariable Long idCaminhao) {
        return caminhaoService.retornarColeta(idEmpresa, idCaminhao);
    }

}
