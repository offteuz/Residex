package br.com.fiap.residex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_recipiente")
public class Recipiente {

    @Id
    @GeneratedValue(
            generator = "seq_recipiente",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_recipiente",
            sequenceName = "seq_recipiente",
            allocationSize = 1
    )
    @Column(name = "id_recipiente")
    private Long idRecipiente;

    @Column(name = "tipo_residuo")
    private String tipoResiduo;

    @Column(name = "capacidade_atual")
    private double capacidadeAtual;

    @Column(name = "capacidade_maxima")
    private double capacidadeMaxima;

    @JoinColumn(
            name = "id_morador",
            referencedColumnName = "id_morador"
    )
    @ManyToOne
    @JsonIgnore
    private Morador morador;

    @Embedded
    private Coordenada coordenada;
}
