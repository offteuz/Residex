package br.com.fiap.residex.controller;

import br.com.fiap.residex.dto.cadastro.NotificacaoCadastroDto;
import br.com.fiap.residex.dto.exibicao.NotificacaoExibicaoDto;
import br.com.fiap.residex.service.NotificaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificaoController {

    @Autowired
    private NotificaoService notificaoService;

    @PostMapping("/notificacao")
    @ResponseStatus(HttpStatus.CREATED)
    private NotificacaoExibicaoDto create (
            @RequestBody NotificacaoCadastroDto notificacaoCadastroDto) {
        return notificaoService.create(notificacaoCadastroDto);
    }

    @GetMapping("/notificacao")
    @ResponseStatus(HttpStatus.OK)
    private List<NotificacaoExibicaoDto> findAll() {
        return notificaoService.findAll();
    }
}
