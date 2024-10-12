package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Coordenada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public record EmpresaCadastroDto(

        Long idEmpresa,

        @CNPJ
        @NotBlank
        String cnpj,

        @Length(
                min = 2,
                max = 60
        )
        @NotBlank
        String razaoSocial,

        @NotNull
        Coordenada coordenada
) {
}
