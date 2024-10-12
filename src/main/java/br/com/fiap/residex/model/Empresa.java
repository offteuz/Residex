package br.com.fiap.residex.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_empresa")
public class Empresa {

    @Id
    @GeneratedValue(
            generator = "seq_empresa",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_empresa",
            sequenceName = "seq_empresa",
            allocationSize = 1
    )
    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Embedded
    private Coordenada coordenada;

    @OneToMany(mappedBy = "empresa")
    private List<Caminhao> caminhoes;
}
