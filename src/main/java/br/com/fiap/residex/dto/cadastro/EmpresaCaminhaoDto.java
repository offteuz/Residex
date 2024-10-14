package br.com.fiap.residex.dto.cadastro;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public record EmpresaCaminhaoDto(

        Long idEmpresa,

        @CNPJ
        @NotBlank
        String cnpj,

        @Length(
                min = 2,
                max = 60
        )
        @NotBlank
        String razaoSocial
) {
}
