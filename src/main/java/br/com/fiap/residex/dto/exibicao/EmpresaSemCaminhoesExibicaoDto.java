package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Empresa;

import java.util.List;

public record EmpresaSemCaminhoesExibicaoDto(

        Long idEmpresa,

        String cnpj,

        String razaoSocial,

        Coordenada coordenada
) {

    public EmpresaSemCaminhoesExibicaoDto(Empresa empresa) {
        this(
                empresa.getIdEmpresa(),
                empresa.getCnpj(),
                empresa.getRazaoSocial(),
                empresa.getCoordenada()
        );
    }
}
