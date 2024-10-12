package br.com.fiap.residex.repository;

import br.com.fiap.residex.dto.exibicao.NotificacaoExibicaoDto;
import br.com.fiap.residex.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
