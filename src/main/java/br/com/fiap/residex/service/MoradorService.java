package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.MoradorCadastroDto;
import br.com.fiap.residex.dto.exibicao.MoradorExibicaoDto;
import br.com.fiap.residex.model.Morador;
import br.com.fiap.residex.repository.MoradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private Morador morador;

    @Autowired
    private MoradorRepository moradorRepository;

    public MoradorExibicaoDto create (MoradorCadastroDto moradorCadastroDto) {

        BeanUtils.copyProperties(moradorCadastroDto, morador);

        return new MoradorExibicaoDto(moradorRepository.save(morador));
    }

    public MoradorExibicaoDto findById (Long idMorador) {

        return moradorRepository.findMoradorByIdMorador(idMorador);
    }

    public void delete (Long idMorador) {

        morador = moradorRepository.findById(idMorador)
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado!"));

        moradorRepository.deleteById(idMorador);
    }
}
