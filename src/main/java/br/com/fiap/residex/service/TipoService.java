package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.TipoCadastroDto;
import br.com.fiap.residex.dto.exibicao.TipoExibicaoDto;
import br.com.fiap.residex.model.Tipo;
import br.com.fiap.residex.repository.TipoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService {

    @Autowired
    private Tipo tipo;

    @Autowired
    private TipoRepository tipoRepository;

    public TipoExibicaoDto create(TipoCadastroDto tipoCadastroDto) {

        BeanUtils.copyProperties(tipoCadastroDto, tipo);

        return new TipoExibicaoDto(tipoRepository.save(tipo));
    }
}
