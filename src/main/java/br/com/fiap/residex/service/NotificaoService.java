package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.NotificacaoCadastroDto;
import br.com.fiap.residex.dto.exibicao.NotificacaoExibicaoDto;
import br.com.fiap.residex.model.Notificacao;
import br.com.fiap.residex.repository.NotificacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificaoService {

    @Autowired
    private Notificacao notificacao;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoExibicaoDto create (NotificacaoCadastroDto notificacaoCadastroDto) {

        BeanUtils.copyProperties(notificacaoCadastroDto, notificacao);

        return new NotificacaoExibicaoDto(notificacaoRepository.save(notificacao));
    }

    public List<NotificacaoExibicaoDto> findAll() {

        return notificacaoRepository
                .findAll()
                .stream()
                .map(NotificacaoExibicaoDto::new)
                .toList();
    }
}
