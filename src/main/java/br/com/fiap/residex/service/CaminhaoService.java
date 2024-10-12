package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.CaminhaoCadastroDto;
import br.com.fiap.residex.dto.cadastro.CaminhaoColetaDto;
import br.com.fiap.residex.dto.exibicao.CaminhaoExibicaoDto;
import br.com.fiap.residex.dto.exibicao.CaminhaoRastreioDto;
import br.com.fiap.residex.exception.CaminhaoNotFoundException;
import br.com.fiap.residex.exception.RecipienteNotFoundException;
import br.com.fiap.residex.model.*;
import br.com.fiap.residex.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private Caminhao caminhao;

    @Autowired
    private Recipiente recipiente;

    @Autowired
    private Status status;

    @Autowired
    private Notificacao notificacao;

    @Autowired
    private Empresa empresa;

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private RecipienteRepository recipienteRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public CaminhaoExibicaoDto create(CaminhaoCadastroDto caminhaoCadastroDto) {

        Status status = statusRepository.findById(5L)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

        Empresa empresa = empresaRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);

        caminhao.setStatus(status);

        caminhao.setCoordenada(empresa.getCoordenada());

        return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
    }

    public List<CaminhaoExibicaoDto> findAll() {

        return caminhaoRepository
                .findAll()
                .stream()
                .map(CaminhaoExibicaoDto::new)
                .toList();
    }

    public List<CaminhaoRastreioDto> findByStatus(String status) {

        return caminhaoRepository.findCaminhaoByStatus(status);
    }

    public CaminhaoRastreioDto findById(Long idCaminhao) {

        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(idCaminhao);

        if (caminhaoOptional.isPresent()) {
            return new CaminhaoRastreioDto(caminhao);
        } else {
            throw new CaminhaoNotFoundException();
        }
    }

    public CaminhaoExibicaoDto sairParaColeta(Long idRecipiente, Long idCaminhao) {

        recipiente = recipienteRepository.findById(idRecipiente)
                .orElseThrow(() -> new RecipienteNotFoundException());

        caminhao = caminhaoRepository.findById(idCaminhao)
                .orElseThrow(() -> new CaminhaoNotFoundException());

        status = statusRepository.findByDescricaoStatus("Em Operação");

        if (recipiente.getCapacidadeAtual() >= recipiente.getCapacidadeMaxima() * 0.8
                && !status.equals(caminhao.getStatus().getDescricaoStatus())) {

            caminhao.setCoordenada(recipiente.getCoordenada());
            caminhao.setStatus(status);

            recipiente.setCapacidadeAtual(0);

            notificacao.setDescricaoNotificacao("Recipiente atingiu 80% da capacidade. Coleta realizada.");
            notificacao.setMorador(recipiente.getMorador());
            notificacao.setRecipiente(recipiente);
            notificacaoRepository.save(notificacao);

            return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
        } else {
            throw new RuntimeException("Erro!");
        }
    }

    public CaminhaoExibicaoDto retornarColeta(Long idEmpresa, Long idCaminhao) {

        empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrado."));

        caminhao = caminhaoRepository.findById(idCaminhao)
                .orElseThrow(() -> new CaminhaoNotFoundException());

        if ("Em Operação".equals(caminhao.getStatus().getDescricaoStatus())) {

            status = statusRepository.findByDescricaoStatus("Disponível");

            caminhao.setCoordenada(empresa.getCoordenada());
            caminhao.setStatus(status);

            return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
        } else {
            throw new RuntimeException("O caminhão não se encontra em operação. Atualmente ele se encontra com o status: " + caminhao.getStatus().getDescricaoStatus());
        }
    }
}
