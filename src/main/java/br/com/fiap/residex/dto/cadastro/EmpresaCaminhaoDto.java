package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Empresa;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public record EmpresaCaminhaoDto(

        Long idEmpresa,

        String cnpj,

        String razaoSocial
) {

        public EmpresaCaminhaoDto(Empresa empresa) {

                this(
                        empresa.getIdEmpresa(),
                        empresa.getCnpj(),
                        empresa.getRazaoSocial()
                );
        }
}
