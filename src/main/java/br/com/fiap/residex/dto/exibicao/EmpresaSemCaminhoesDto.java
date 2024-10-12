package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Empresa;

public record EmpresaSemCaminhoesDto(

        Long idEmpresa,

        String cnpj,

        String razaoSocial
) {

    public EmpresaSemCaminhoesDto(Empresa empresa) {
        this(
                empresa.getIdEmpresa(),
                empresa.getCnpj(),
                empresa.getRazaoSocial()
        );
    }
}
