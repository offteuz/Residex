package br.com.fiap.residex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "t_morador")
public class Morador {

    @Id
    @GeneratedValue(
            generator = "seq_morador",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_morador",
            sequenceName = "seq_morador",
            allocationSize = 1
    )
    @Column(name = "id_morador")
    private Long idMorador;

    @Column(name = "nome_morador")
    private String nomeMorador;

    private String email;

    private String telefone;

    private String logradouro;

    @Embedded
    private Coordenada coordenada;

    @OneToMany(mappedBy = "morador")
    @JsonIgnore
    private List<Recipiente> recipientes;

    @OneToMany(mappedBy = "morador")
    @JsonIgnore
    private List<Notificacao> notificacoes;
}
