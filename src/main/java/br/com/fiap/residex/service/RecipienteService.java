package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.RecipienteCadastroDto;
import br.com.fiap.residex.dto.exibicao.RecipienteExibicaoDto;
import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.model.Recipiente;
import br.com.fiap.residex.repository.CaminhaoRepository;
import br.com.fiap.residex.repository.MoradorRepository;
import br.com.fiap.residex.repository.RecipienteRepository;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipienteService {

    @Autowired
    private Recipiente recipiente;

    @Autowired
    private Caminhao caminhao;

    @Autowired
    private Morador morador;

    @Autowired
    private RecipienteRepository recipienteRepository;

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    public RecipienteExibicaoDto create(RecipienteCadastroDto recipienteCadastroDto, Long idMorador) {

        BeanUtils.copyProperties(recipienteCadastroDto, recipiente);

        morador = moradorRepository.findById(idMorador)
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado!"));

        recipiente.setMorador(morador);

        recipiente.setCoordenada(morador.getCoordenada());

        return new RecipienteExibicaoDto(recipienteRepository.save(recipiente));
    }

    public List<Recipiente> findAll() {

        return recipienteRepository.findAll();
    }

    public void delete(Long idRecipiente) {

        recipiente = recipienteRepository.findById(idRecipiente)
                .orElseThrow(() -> new EntityNotFoundException("Recipiente não encontrado!"));

        recipienteRepository.delete(recipiente);
    }
}
