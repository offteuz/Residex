package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.StatusCadastroDto;
import br.com.fiap.residex.dto.cadastro.StatusUpdateDto;
import br.com.fiap.residex.dto.exibicao.StatusExibicaoDto;
import br.com.fiap.residex.model.Status;
import br.com.fiap.residex.repository.StatusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private Status status;

    @Autowired
    private StatusRepository statusRepository;

    public StatusExibicaoDto create(StatusCadastroDto statusCadastroDto) {

        BeanUtils.copyProperties(statusCadastroDto, status);

        return new StatusExibicaoDto(statusRepository.save(status));
    }

    public List<StatusExibicaoDto> findAll() {

        return statusRepository
                .findAll()
                .stream()
                .map(StatusExibicaoDto::new)
                .toList();
    }

    public StatusExibicaoDto findById(Long idStatus) {

        status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

        return new StatusExibicaoDto(status);
    }

    public List<StatusExibicaoDto> findByDescricao(String descricaoStatus) {

        return statusRepository.findByDescricaoStatusContaining(descricaoStatus);
    }

    public void delete(Long idStatus) {

        status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("Status não encontrado!"));

        statusRepository.delete(status);
    }

    public StatusExibicaoDto update(Long idStatus, StatusUpdateDto statusParam) {

        status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

        if (statusParam.descricaoStatus() != null) {
            status.setDescricaoStatus(statusParam.descricaoStatus());
        }

        Status statusAtualizado = statusRepository.save(status);
        return new StatusExibicaoDto(statusAtualizado);
    }
}
