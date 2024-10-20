package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Empresa;

import java.util.List;

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
