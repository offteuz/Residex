package br.com.fiap.residex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_item")
public class Item {

    @Id
    @GeneratedValue(
            generator = "seq_item",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_item",
            sequenceName = "seq_item",
            allocationSize = 1
    )
    @Column(name = "id_item")
    private Long idItem;

    @Column(name = "descricao_item")
    private String descricaoItem;

    @Column(name = "peso_item")
    private Double pesoItem;

    @JoinColumn(
            name = "id_recipiente",
            referencedColumnName = "id_recipiente"
    )
    @ManyToOne
    @JsonIgnore
    private Recipiente recipiente;

    @JoinColumn(
            name = "id_tipo",
            referencedColumnName = "id_tipo"
    )
    @ManyToOne
    @JsonIgnore
    private Tipo tipo;
}
