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

    @Embedded
    private Capacidade capacidade;

    @Embedded
    private Coordenada coordenada;

    @JoinColumn(
            name = "id_morador",
            referencedColumnName = "id_morador"
    )
    @ManyToOne
    @JsonIgnore
    private Morador morador;

    @JoinColumn(
            name = "id_tipo",
            referencedColumnName = "id_tipo"
    )
    @ManyToOne
    @JsonIgnore
    private Tipo tipo;

    @OneToMany(mappedBy = "recipiente")
    private List<Item> items;
}
