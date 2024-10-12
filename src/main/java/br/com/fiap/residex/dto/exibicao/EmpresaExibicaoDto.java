package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public record EmpresaExibicaoDto(

        Long idEmpresa,

        String cnpj,

        String razaoSocial,

        Coordenada coordenada,

        List<Caminhao> caminhoes
) {

    public EmpresaExibicaoDto(Empresa empresa) {
        this(
                empresa.getIdEmpresa(),
                empresa.getCnpj(),
                empresa.getRazaoSocial(),
                empresa.getCoordenada(),
                empresa.getCaminhoes()
        );
    }
}
